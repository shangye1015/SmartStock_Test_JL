package net.luculent.trenddbmanage.inventory.controller;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.inventory.dto.InventoryQueryRequest;
import net.luculent.trenddbmanage.inventory.dto.InventoryResponse;
import net.luculent.trenddbmanage.inventory.service.InventoryService;
import net.luculent.trenddbmanage.utils.ResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 库存统计接口
 * 提供库存分页查询能力
 *
 * @author shangye
 * @date 2025-06-28
 */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    /**
     * 分页查询库存信息
     * @param request 查询参数（支持仓库名/物品名模糊查询）
     * @return 分页库存列表
     */
    @PostMapping("/list")
    public Result<PageResult<InventoryResponse>> listInventory(@Validated @RequestBody InventoryQueryRequest request) {
        return ResultUtils.success(inventoryService.queryInventory(request));
    }
}
