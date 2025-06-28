package net.luculent.trenddbmanage.item.service.impl;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.item.dao.CategoryMapper;
import net.luculent.trenddbmanage.item.dto.*;
import net.luculent.trenddbmanage.item.entity.Category;
import net.luculent.trenddbmanage.item.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 物品分类服务实现类
 * 负责分类的业务逻辑处理
 *
 * @author shangye
 * @date 2025-06-28
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public void createCategory(CategoryCreateRequest req) {
        Category category = Category.builder()
                .name(req.getName())
                .sortOrder(req.getSortOrder() != null ? req.getSortOrder() : 0)
                .status(req.getStatus() != null ? req.getStatus() : 1)
                .build();
        categoryMapper.insert(category);
    }

    @Override
    public void updateCategory(CategoryUpdateRequest req) {
        Category category = Category.builder()
                .id(req.getId())
                .name(req.getName())
                .sortOrder(req.getSortOrder())
                .status(req.getStatus())
                .build();
        categoryMapper.update(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteById(id);
    }

    @Override
    public CategoryResponse getCategoryById(Integer id) {
        Category category = categoryMapper.selectById(id);
        if (category == null) {
            return null;
        }
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .sortOrder(category.getSortOrder())
                .status(category.getStatus())
                .build();
    }

    @Override
    public PageResult<CategoryResponse> queryCategories(CategoryQueryRequest req) {
        String name = StringUtils.hasText(req.getName()) ? req.getName() : null;
        int offset = (req.getPage() - 1) * req.getSize();
        List<Category> list = categoryMapper.selectByName(name, offset, req.getSize());
        int total = categoryMapper.countByName(name);
        List<CategoryResponse> records = list.stream()
                .map(c -> CategoryResponse.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .sortOrder(c.getSortOrder())
                        .status(c.getStatus())
                        .build())
                .collect(Collectors.toList());
        return new PageResult<>(total, records);
    }
}
