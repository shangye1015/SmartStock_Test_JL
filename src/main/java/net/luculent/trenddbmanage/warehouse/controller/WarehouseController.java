package net.luculent.trenddbmanage.warehouse.controller;


import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.utils.PageResult;
import net.luculent.trenddbmanage.utils.ResultUtils;
import net.luculent.trenddbmanage.warehouse.dto.*;
import net.luculent.trenddbmanage.warehouse.service.WarehouseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouse")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping("/create")
    public Result<Void> createWarehouse(@Validated @RequestBody WarehouseCreateRequest request) {
        warehouseService.createWarehouse(request);
        return ResultUtils.success();
    }

    @PostMapping("/update")
    public Result<Void> updateWarehouse(@Validated @RequestBody WarehouseUpdateRequest request) {
        warehouseService.updateWarehouse(request);
        return ResultUtils.success();
    }

    @PostMapping("/delete")
    public Result<Void> deleteWarehouse(@Validated @RequestBody WarehouseDeleteRequest request) {
        warehouseService.deleteWarehouse(request);
        return ResultUtils.success();
    }

    @PostMapping("/list")
    public Result<PageResult<WarehouseResponse>> list(@Validated @RequestBody WarehouseQueryRequest request) {
        return ResultUtils.success(warehouseService.queryWarehouses(request));
    }
}

