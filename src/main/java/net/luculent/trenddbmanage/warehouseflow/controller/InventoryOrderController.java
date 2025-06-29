package net.luculent.trenddbmanage.warehouseflow.controller;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.utils.ResultUtils;
import net.luculent.trenddbmanage.warehouseflow.dto.*;
import net.luculent.trenddbmanage.warehouseflow.service.InventoryOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 出入库单据接口控制器
 * 提供单据的增删改查、确认等功能
 *
 * @author shangye
 * @date 2025-06-28
 */
@RestController
@RequestMapping("/api/inventory-orders")
@RequiredArgsConstructor
@Validated
public class InventoryOrderController {

    private final InventoryOrderService orderService;

    @PostMapping("/create")
    public Result<Void> createOrder(@Valid @RequestBody InventoryOrderRequest request) {
        orderService.createOrder(request);
        return ResultUtils.success();
    }

    @PostMapping("/update")
    public Result<Void> updateOrder(@Valid @RequestBody InventoryOrderRequest request) {
        orderService.updateOrder(request);
        return ResultUtils.success();
    }

    @PostMapping("/delete")
    public Result<Void> deleteOrder(@Valid @RequestBody InventoryOrderDeleteRequest request) {
        orderService.deleteOrder(request.getOrderId());
        return ResultUtils.success();
    }

    @PostMapping("/get")
    public Result<InventoryOrderItemResponse> getOrderDetail(@Valid @RequestBody InventoryOrderGetRequest request) {
        InventoryOrderItemResponse detail = orderService.getOrderDetail(request.getOrderId());
        return ResultUtils.success(detail);
    }

    @PostMapping("/list")
    public Result<PageResult<InventoryOrderResponse>> listOrders(@Valid @RequestBody InventoryOrderQueryRequest request) {
        PageResult<InventoryOrderResponse> result = orderService.listOrders(request.getPage(), request.getSize());
        return ResultUtils.success(result);
    }

    @PostMapping("/confirm")
    public Result<Void> confirmOrder(@Valid @RequestBody InventoryOrderConfirmRequest request) {
        orderService.confirmOrder(request.getOrderId());
        return ResultUtils.success();
    }
}
