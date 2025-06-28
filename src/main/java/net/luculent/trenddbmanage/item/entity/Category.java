package net.luculent.trenddbmanage.item.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * 物品分类实体类
 * 代表库存系统中的物品分类信息（平级分类）
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    private Integer id;
    private String name;
    private Integer sortOrder;
    private Integer status;
}

