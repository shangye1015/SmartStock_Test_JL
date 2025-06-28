package net.luculent.trenddbmanage.item.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 物品分类实体类
 *
 * 表示库存系统中的一个物品分类（不支持子类，所有分类为平级），
 * 用于在物品管理、物品统计中进行分类归属。
 *
 * 字段说明：
 * - id：主键，自增
 * - name：分类名称（唯一）
 * - sortOrder：排序字段，用于前端展示顺序
 * - status：状态（1=启用，0=禁用）
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    /**
     * 分类主键 ID
     */
    private Integer id;

    /**
     * 分类名称（唯一）
     */
    private String name;

    /**
     * 排序字段（值越小越靠前）
     */
    private Integer sortOrder;

    /**
     * 状态（1 = 启用，0 = 禁用）
     */
    private Integer status;
}
