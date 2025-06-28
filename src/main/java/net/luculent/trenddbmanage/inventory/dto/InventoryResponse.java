package net.luculent.trenddbmanage.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 库存响应 DTO
 * 用于封装库存查询结果返回给前端
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {

    /** 库存记录 ID（主键） */
    private Integer inventoryId;

    /** 仓库名称 */
    private String warehouseName;

    /** 物品名称 */
    private String itemName;

    /** 分类名称（例如：电子工具、耗材等） */
    private String categoryName;

    /** 物品规格 */
    private String specification;

    /** 单位（如：件、箱） */
    private String unit;

    /** 当前库存数量 */
    private Integer quantity;

    /** 库存最后更新时间 */
    private LocalDateTime lastUpdated;
}
