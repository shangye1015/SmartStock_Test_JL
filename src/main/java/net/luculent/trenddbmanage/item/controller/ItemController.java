package net.luculent.trenddbmanage.item.controller;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.item.dto.*;
import net.luculent.trenddbmanage.item.service.ItemService;
import net.luculent.trenddbmanage.utils.ResultUtils;
import net.luculent.trenddbmanage.warehouse.dto.WarehouseDeleteRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物品管理控制器
 * 提供物品相关的增删改查接口
 * 使用POST请求，支持分页和条件查询
 *
 * @author shangye
 * @date 2025-06-28
 */
@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    /**
     * 新增物品
     * @param req 物品创建请求
     * @return 统一结果封装
     */
    @PostMapping("/create")
    public Result<Void> createItem(@Validated @RequestBody ItemCreateRequest req) {
        itemService.createItem(req);
        return ResultUtils.success();
    }

    /**
     * 更新物品信息
     * @param req 物品更新请求，必须包含id
     * @return 统一结果封装
     */
    @PostMapping("/update")
    public Result<Void> updateItem(@Validated @RequestBody ItemUpdateRequest req) {
        itemService.updateItem(req);
        return ResultUtils.success();
    }

    /**
     * 删除物品
     * @param request 物品ID
     * @return 统一结果封装
     */
    @PostMapping("/delete")
    public Result<Void> deleteItem(@Validated @RequestBody WarehouseDeleteRequest request) {
        itemService.deleteItem(request.getId());
        return ResultUtils.success();
    }


    /**
     * 根据ID查询物品详情
     * @param id 物品ID
     * @return 物品详情响应对象
     */
    @PostMapping("/get")
    public Result<ItemResponse> getItemById(@RequestParam Integer id) {
        ItemResponse item = itemService.getItemById(id);
        return ResultUtils.success(item);
    }

    /**
     * 分页查询物品列表，支持名称模糊匹配及分类筛选
     * @param req 查询请求，包含分页和筛选条件
     * @return 分页物品列表
     */
    @PostMapping("/list")
    public Result<PageResult<ItemResponse>> listItems(@RequestBody ItemQueryRequest req) {
        PageResult<ItemResponse> pageResult = itemService.queryItems(req);
        return ResultUtils.success(pageResult);
    }
}
