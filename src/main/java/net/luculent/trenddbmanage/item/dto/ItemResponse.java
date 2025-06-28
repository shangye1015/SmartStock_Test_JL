package net.luculent.trenddbmanage.item.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 物品响应 DTO
 *
 * 用于向前端或调用方返回物品信息，包含物品的基本属性和状态信息。
 * 与实体类 Item 一一对应，但专注于数据传输，避免暴露实体内部实现细节。
 *
 * 字段说明：
 * - id：物品唯一标识
 * - sku：物品编号（唯一）
 * - name：物品名称
 * - categoryId：所属分类 ID
 * - specification：规格信息
 * - unit：单位
 * - price：单价
 * - status：状态（1=启用，0=禁用）
 * - createdAt：创建时间
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
public class ItemResponse {
    /**
     * 物品唯一标识
     */
    private Integer id;

    /**
     * 物品编号（SKU）
     */
    private String sku;

    /**
     * 物品名称
     */
    private String name;

    /**
     * 物品所属分类 ID
     */
    private Integer categoryId;

    /**
     * 规格信息
     */
    private String specification;

    /**
     * 单位
     */
    private String unit;

    /**
     * 单价
     */
    private Double price;

    /**
     * 状态（1=启用，0=禁用）
     */
    private Integer status;

    /**
     * 物品创建时间
     */
    private LocalDateTime createdAt;
}
