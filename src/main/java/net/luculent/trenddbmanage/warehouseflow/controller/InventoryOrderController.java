package net.luculent.trenddbmanage.warehouseflow.controller;

import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.warehouseflow.dto.*;
import net.luculent.trenddbmanage.warehouseflow.service.InventoryOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 出入库单据接口控制器
 *
 * @author shangye
 * @date 2025-06-28
 */
@RestController
@RequestMapping("/api/inventory-orders")
@Validated
public class InventoryOrderController {

    private final InventoryOrderService orderService;

    public InventoryOrderController(InventoryOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 创建出入库单据
     */
    @PostMapping
    public void createOrder(@Valid @RequestBody InventoryOrderRequest request) {
        orderService.createOrder(request);
    }

    /**
     * 修改出入库单据（仅 PENDING 状态允许）
     */
    @PutMapping
    public void updateOrder(@Valid @RequestBody InventoryOrderRequest request) {
        orderService.updateOrder(request);
    }

    /**
     * 删除出入库单据（仅 PENDING 状态允许）
     */
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
    }

    /**
     * 查询单据详情（含明细）
     */
    @GetMapping("/{orderId}")
    public InventoryOrderItemResponse getOrderDetail(@PathVariable Integer orderId) {
        return orderService.getOrderDetail(orderId);
    }

    /**
     * 查询出入库单据分页列表
     */
    @GetMapping
    public PageResult<InventoryOrderResponse> listOrders(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return orderService.listOrders(page, size);
    }

    /**
     * 确认出入库操作
     */
    @PostMapping("/{orderId}/confirm")
    public void confirmOrder(@PathVariable Integer orderId) {
        orderService.confirmOrder(orderId);
    }
}

