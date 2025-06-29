package net.luculent.trenddbmanage.item.controller;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.item.dto.*;
import net.luculent.trenddbmanage.item.service.CategoryService;
import net.luculent.trenddbmanage.utils.ResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 物品分类管理接口
 * 提供分类的增删改查功能
 *
 * @author shangye
 * @date 2025-06-28
 */
@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public Result<Void> createCategory(@Valid @RequestBody CategoryCreateRequest req) {
        categoryService.createCategory(req);
        return ResultUtils.success();
    }

    @PostMapping("/update")
    public Result<Void> updateCategory(@Valid @RequestBody CategoryUpdateRequest req) {
        categoryService.updateCategory(req);
        return ResultUtils.success();
    }

    @PostMapping("/delete")
    public Result<Void> deleteCategory(@Validated @RequestBody CategoryDeleteRequest request) {
        categoryService.deleteCategory(request.getId());
        return ResultUtils.success();
    }


    @PostMapping("/get")
    public Result<CategoryResponse> getCategory(@RequestParam Integer id) {
        CategoryResponse resp = categoryService.getCategoryById(id);
        return ResultUtils.success(resp);
    }

    @PostMapping("/list")
    public Result<PageResult<CategoryResponse>> listCategories(@Valid @RequestBody CategoryQueryRequest req) {
        PageResult<CategoryResponse> pageResult = categoryService.queryCategories(req);
        return ResultUtils.success(pageResult);
    }
}
