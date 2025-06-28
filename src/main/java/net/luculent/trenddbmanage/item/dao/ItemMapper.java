package net.luculent.trenddbmanage.item.dao;

import net.luculent.trenddbmanage.item.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 物品持久层接口
 * 负责物品的增删改查操作
 * 支持分页和模糊查询
 *
 * @author shangye
 * @date 2025-06-28
 */
@Mapper
public interface ItemMapper {

    /**
     * 插入新物品
     * @param item 物品实体
     * @return 受影响行数
     */
    int insert(Item item);

    /**
     * 根据ID更新物品（支持动态更新非空字段）
     * @param item 物品实体
     * @return 受影响行数
     */
    int update(Item item);

    /**
     * 根据ID删除物品
     * @param id 物品ID
     * @return 受影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据ID查询物品详情
     * @param id 物品ID
     * @return 物品实体
     */
    Item selectById(Integer id);

    /**
     * 分页条件查询物品列表，支持物品名模糊和分类筛选
     * @param name 物品名称模糊匹配
     * @param categoryId 分类ID筛选
     * @param offset 偏移量
     * @param limit 每页条数
     * @return 物品列表
     */
    List<Item> selectByNameAndCategory(@Param("name") String name,
                                       @Param("categoryId") Integer categoryId,
                                       @Param("offset") int offset,
                                       @Param("limit") int limit);

    /**
     * 统计满足条件的物品总数
     * @param name 物品名称模糊匹配
     * @param categoryId 分类ID筛选
     * @return 总记录数
     */
    int countByNameAndCategory(@Param("name") String name,
                               @Param("categoryId") Integer categoryId);
}


