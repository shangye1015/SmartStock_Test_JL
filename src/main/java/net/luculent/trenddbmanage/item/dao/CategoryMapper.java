package net.luculent.trenddbmanage.item.dao;

import net.luculent.trenddbmanage.item.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 物品分类持久层接口
 * 负责分类的增删改查操作
 * 支持分页和模糊查询
 *
 * @author shangye
 * @date 2025-06-28
 */
@Mapper
public interface CategoryMapper {

    /**
     * 新增分类
     * @param category 分类实体
     * @return 受影响行数
     */
    int insert(Category category);

    /**
     * 更新分类，动态更新非空字段
     * @param category 分类实体
     * @return 受影响行数
     */
    int update(Category category);

    /**
     * 根据ID删除分类
     * @param id 分类ID
     * @return 受影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据ID查询分类详情
     * @param id 分类ID
     * @return 分类实体
     */
    Category selectById(Integer id);

    /**
     * 分页条件查询分类列表，支持名称模糊搜索
     * @param name 分类名称模糊匹配
     * @param offset 偏移量
     * @param limit 每页大小
     * @return 分类列表
     */
    List<Category> selectByName(@Param("name") String name,
                                @Param("offset") int offset,
                                @Param("limit") int limit);

    /**
     * 统计满足条件的分类总数
     * @param name 分类名称模糊匹配
     * @return 总记录数
     */
    int countByName(@Param("name") String name);
}

