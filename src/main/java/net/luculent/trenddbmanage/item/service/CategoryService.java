package net.luculent.trenddbmanage.item.service;

import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.item.dto.*;

public interface CategoryService {

    /**
     * 新增分类
     * @param req 创建分类请求参数
     */
    void createCategory(CategoryCreateRequest req);

    /**
     * 修改分类（支持动态更新非空字段）
     * @param req 修改分类请求参数
     */
    void updateCategory(CategoryUpdateRequest req);

    /**
     * 删除分类
     * @param id 分类ID
     */
    void deleteCategory(Integer id);

    /**
     * 根据ID查询分类详情
     * @param id 分类ID
     * @return 分类详情
     */
    CategoryResponse getCategoryById(Integer id);

    /**
     * 分页模糊查询分类列表
     * @param req 查询请求参数，支持分页和名称模糊
     * @return 分页结果
     */
    PageResult<CategoryResponse> queryCategories(CategoryQueryRequest req);
}
