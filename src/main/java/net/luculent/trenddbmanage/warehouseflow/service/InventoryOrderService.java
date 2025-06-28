package net.luculent.trenddbmanage.warehouseflow.service;




import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.warehouseflow.dto.InventoryOrderItemResponse;
import net.luculent.trenddbmanage.warehouseflow.dto.InventoryOrderRequest;
import net.luculent.trenddbmanage.warehouseflow.dto.InventoryOrderResponse;

import java.util.List;

/**
 * 出入库单据业务逻辑接口
 *
 * 包含出入库单据的增删改查、确认出/入库功能
 *
 * @author shangye
 * @date 2025-06-28
 */
public interface InventoryOrderService {

    /**
     * 创建出入库单据及其明细记录
     *
     * @param request 创建请求
     */
    void createOrder(InventoryOrderRequest request);

    /**
     * 修改出入库单据信息（仅在 PENDING 状态下允许）
     *
     * @param request 修改请求
     */
    void updateOrder(InventoryOrderRequest request);

    /**
     * 删除出入库单（仅在 PENDING 状态下允许）
     *
     * @param orderId 单据ID
     */
    void deleteOrder(Integer orderId);

    /**
     * 查询出入库单据详情（包含明细记录）
     *
     * @param orderId 单据ID
     * @return 单据 + 明细列表
     */
    InventoryOrderItemResponse getOrderDetail(Integer orderId);

    /**
     * 查询所有出入库单据（支持分页）
     *
     * @param page 页码
     * @param size 每页数量
     * @return 单据分页结果
     */
    PageResult<InventoryOrderResponse> listOrders(int page, int size);

    /**
     * 确认出入库操作
     * 包括：
     * - 校验库存是否足够（出库）
     * - 修改库存表数据
     * - 更新出入库单状态为 COMPLETED
     *
     * @param orderId 单据ID
     */
    void confirmOrder(Integer orderId);
}

