package net.luculent.trenddbmanage.warehouse.controller;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.utils.ResultUtils;
import net.luculent.trenddbmanage.warehouse.dto.*;
import net.luculent.trenddbmanage.warehouse.service.WarehouseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 仓库管理控制器
 *
 * 提供仓库信息的创建、更新、删除和分页查询接口
 * 所有接口均使用 POST 方法，并对请求参数进行合法性校验
 */
@RestController
@RequestMapping("/api/warehouse")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    /**
     * 创建仓库信息
     *
     * @param request 包含仓库名称、地址等基本信息
     * @return 通用成功响应
     */
    @PostMapping("/create")
    public Result<Void> createWarehouse(@Validated @RequestBody WarehouseCreateRequest request) {
        warehouseService.createWarehouse(request);
        return ResultUtils.success();
    }

    /**
     * 更新仓库信息
     *
     * @param request 包含要更新的仓库ID以及修改后的字段值
     * @return 通用成功响应
     */
    @PostMapping("/update")
    public Result<Void> updateWarehouse(@Validated @RequestBody WarehouseUpdateRequest request) {
        warehouseService.updateWarehouse(request);
        return ResultUtils.success();
    }

    /**
     * 删除仓库信息
     *
     * @param request 包含要删除的仓库ID
     * @return 通用成功响应
     */
    @PostMapping("/delete")
    public Result<Void> deleteWarehouse(@Validated @RequestBody WarehouseDeleteRequest request) {
        warehouseService.deleteWarehouse(request);
        return ResultUtils.success();
    }

    /**
     * 分页查询仓库列表
     *
     * @param request 包含分页参数及可选筛选条件（如仓库名等）
     * @return 仓库分页数据
     */
    @PostMapping("/list")
    public Result<PageResult<WarehouseResponse>> list(@Validated @RequestBody WarehouseQueryRequest request) {
        return ResultUtils.success(warehouseService.queryWarehouses(request));
    }
}
