package net.luculent.trenddbmanage.item.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 物品实体类
 *
 * 表示库存系统中的物品信息，支持按分类管理、单价统计、状态启用/禁用控制等功能。
 *
 * 字段说明：
 * - id：主键，自增
 * - sku：物品编号（唯一标识物品，可用于扫码）
 * - name：物品名称
 * - categoryId：分类 ID（关联 Category 表）
 * - specification：规格（如型号、尺寸）
 * - unit：单位（如：个、箱、斤、米）
 * - price：单价（默认单位价格）
 * - status：状态（1=启用，0=禁用）
 * - createdAt：创建时间（记录物品录入时间）
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    /**
     * 主键 ID（自增）
     */
    private Integer id;

    /**
     * 物品编号（SKU，唯一）
     */
    private String sku;

    /**
     * 物品名称
     */
    private String name;

    /**
     * 所属分类 ID
     */
    private Integer categoryId;

    /**
     * 规格信息（如：500ml、型号X123）
     */
    private String specification;

    /**
     * 单位（如：个、箱、米）
     */
    private String unit;

    /**
     * 单价（默认单位价格）
     */
    private Double price;

    /**
     * 状态（1 = 启用，0 = 禁用）
     */
    private Integer status;

    /**
     * 创建时间（物品录入时间）
     */
    private LocalDateTime createdAt;
}
