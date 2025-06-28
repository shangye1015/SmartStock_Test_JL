package net.luculent.trenddbmanage.warehouseflow.service.impl;

import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.inventory.dao.InventoryMapper;
import net.luculent.trenddbmanage.inventory.entity.Inventory;
import net.luculent.trenddbmanage.warehouseflow.dao.InventoryOrderItemMapper;
import net.luculent.trenddbmanage.warehouseflow.dao.InventoryOrderMapper;
import net.luculent.trenddbmanage.warehouseflow.dto.*;
import net.luculent.trenddbmanage.warehouseflow.entity.InventoryOrder;
import net.luculent.trenddbmanage.warehouseflow.entity.InventoryOrderItem;
import net.luculent.trenddbmanage.warehouseflow.service.InventoryOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 出入库单据服务实现类
 * 实现出入库单据的增删改查及确认操作
 *
 * @author shangye
 * @date 2025-06-28
 */
@Service
@SuppressWarnings("ALL")
public class InventoryOrderServiceImpl implements InventoryOrderService {

    private final InventoryOrderMapper orderMapper;
    private final InventoryOrderItemMapper itemMapper;
    private final InventoryMapper inventoryMapper;

    public InventoryOrderServiceImpl(InventoryOrderMapper orderMapper,
                                     InventoryOrderItemMapper itemMapper,
                                     InventoryMapper inventoryMapper) {
        this.orderMapper = orderMapper;
        this.itemMapper = itemMapper;
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    @Transactional
    public void createOrder(InventoryOrderRequest request) {
        InventoryOrder order = new InventoryOrder();
        BeanUtils.copyProperties(request, order);
        order.setStatus("PENDING");
        order.setOperationTime(LocalDateTime.now());

        // 新增主单
        orderMapper.insert(order);

        // 新增明细
        List<InventoryOrderItem> items = request.getItems().stream().map(itemReq -> {
            InventoryOrderItem item = new InventoryOrderItem();
            item.setOrderId(order.getId());
            item.setItemId(itemReq.getItemId());
            item.setQuantity(itemReq.getQuantity());
            return item;
        }).collect(Collectors.toList());

        items.forEach(itemMapper::insert);
    }

    @Override
    @Transactional
    public void updateOrder(InventoryOrderRequest request) {
        InventoryOrder order = orderMapper.selectById(request.getOrderId());
        if (order == null || !"PENDING".equals(order.getStatus())) {
            throw new RuntimeException("只能修改待处理状态的单据");
        }
        // 只允许修改仓库和备注
        order.setWarehouseId(request.getWarehouseId());
        order.setRemark(request.getRemark());
        orderMapper.update(order);

        // 删除原有明细
        itemMapper.deleteByOrderId(order.getId());

        // 新增明细
        List<InventoryOrderItem> items = request.getItems().stream().map(itemReq -> {
            InventoryOrderItem item = new InventoryOrderItem();
            item.setOrderId(order.getId());
            item.setItemId(itemReq.getItemId());
            item.setQuantity(itemReq.getQuantity());
            return item;
        }).collect(Collectors.toList());

        items.forEach(itemMapper::insert);
    }

    @Override
    @Transactional
    public void deleteOrder(Integer orderId) {
        InventoryOrder order = orderMapper.selectById(orderId);
        if (order == null || !"PENDING".equals(order.getStatus())) {
            throw new RuntimeException("只能删除待处理状态的单据");
        }
        // 删除明细
        itemMapper.deleteByOrderId(orderId);
        // 删除主单
        orderMapper.deleteById(orderId);
    }

    /**
     * 订单详情接口不一定用得上
     * @param orderId 单据ID
     * @return
     */
    @Override
    public InventoryOrderItemResponse getOrderDetail(Integer orderId) {
        InventoryOrder order = orderMapper.selectById(orderId);
        if (order == null) {
            throw new RuntimeException("单据不存在");
        }
        List<InventoryOrderItem> items = itemMapper.selectByOrderId(orderId);

        List<InventoryOrderItemResponse> itemResponses = items.stream().map(item -> {
            InventoryOrderItemResponse resp = new InventoryOrderItemResponse();
            BeanUtils.copyProperties(item, resp);
            // TODO: 可通过itemId查询物品名称和单位，这里略
            return resp;
        }).collect(Collectors.toList());

        return InventoryOrderItemResponse.builder()
                .id(order.getId())
                .itemId(null) // 单据层面没itemId
                .itemName(null)
                .quantity(null)
                .unit(null)
                .build();

    }

    @Override
    public PageResult<InventoryOrderResponse> listOrders(int page, int size) {
        List<InventoryOrder> orders = orderMapper.selectAll();
        int total = orders.size();

        List<InventoryOrderResponse> responses = orders.stream().map(order -> {
            InventoryOrderResponse resp = new InventoryOrderResponse();
            BeanUtils.copyProperties(order, resp);
            // 查询明细
            List<InventoryOrderItem> items = itemMapper.selectByOrderId(order.getId());
            List<InventoryOrderItemResponse> itemResponses = items.stream().map(item -> {
                InventoryOrderItemResponse itemResp = new InventoryOrderItemResponse();
                BeanUtils.copyProperties(item, itemResp);
                return itemResp;
            }).collect(Collectors.toList());
            resp.setItems(itemResponses);
            return resp;
        }).collect(Collectors.toList());

        return new PageResult<>(total, responses);
    }

    /**
     * 确认出/入库操作
     * 步骤：
     * 1. 校验单据状态为 PENDING
     * 2. 遍历明细项，判断出入库类型
     * 3. 出库需校验库存数量是否足够
     * 4. 入库可新增或累加库存记录
     * 5. 最后更新单据状态为 COMPLETED
     * 6. TODO：并发问题，应用层面增加事务方式并发，数据库层面加锁
     * @param orderId 单据主键 ID
     */
    @Transactional
    @Override
    public void confirmOrder(Integer orderId) {
        // 1. 查询单据主信息
        InventoryOrder order = orderMapper.selectById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("单据不存在");
        }

        // 2. 校验状态必须为 PENDING（防止重复提交）
        if (!"PENDING".equals(order.getStatus())) {
            throw new IllegalStateException("单据状态非待处理，无法完成");
        }

        // 3. 查询该单据下的所有出入库明细
        List<InventoryOrderItem> details = itemMapper.selectByOrderId(orderId);

        for (InventoryOrderItem detail : details) {
            Integer warehouseId = order.getWarehouseId();
            Integer itemId = detail.getItemId();
            Integer delta = detail.getQuantity();

            // 查询当前库存记录
            Inventory inventory = inventoryMapper.findByWarehouseAndItem(warehouseId, itemId);

            // 4. 出库逻辑
            if ("OUT".equalsIgnoreCase(order.getRecordType())) {
                if (inventory == null || inventory.getQuantity() < delta) {
                    throw new IllegalStateException("库存不足，商品ID: " + itemId);
                }
                // 更新库存：减少数量
                inventoryMapper.updateQuantity(inventory.getId(), inventory.getQuantity() - delta);

                // 5. 入库逻辑
            } else if ("IN".equalsIgnoreCase(order.getRecordType())) {
                if (inventory == null) {
                    // 没有记录则插入一条新的库存记录
                    inventory = Inventory.builder()
                            .warehouseId(warehouseId)
                            .itemId(itemId)
                            .quantity(delta)
                            .build();
                    inventoryMapper.insert(inventory);
                } else {
                    // 已有库存记录则增加数量
                    inventoryMapper.updateQuantity(inventory.getId(), inventory.getQuantity() + delta);
                }

            } else {
                throw new IllegalStateException("不支持的单据类型: " + order.getRecordType());
            }
        }

        // 6. 更新主单状态为 COMPLETED（已完成）
        orderMapper.updateStatus(orderId, "COMPLETED");
    }
}
