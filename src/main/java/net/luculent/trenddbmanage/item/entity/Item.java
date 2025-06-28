package net.luculent.trenddbmanage.item.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 物品实体类
 * 代表库存系统中的物品信息
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private Integer id;
    private String sku;
    private String name;
    private Integer categoryId;
    private String specification;
    private String unit;
    private Double price;
    private Integer status;
    private LocalDateTime createdAt;
}


