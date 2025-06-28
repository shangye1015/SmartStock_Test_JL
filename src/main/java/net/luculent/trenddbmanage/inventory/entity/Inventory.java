package net.luculent.trenddbmanage.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 库存实体类
 *
 * 用于表示仓库中某种物品的库存数量。
 * 每个库存记录由仓库 ID 与物品 ID 唯一确定。
 *
 * 字段说明：
 * - id：主键，自增
 * - warehouseId：所属仓库 ID
 * - itemId：物品 ID
 * - quantity：库存数量
 * - lastUpdated：最后更新时间
 *
 * 表名：inventory
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    /**
     * 库存主键 ID
     */
    private Integer id;

    /**
     * 仓库 ID（外键，关联 warehouse 表）
     */
    private Integer warehouseId;

    /**
     * 物品 ID（外键，关联 item 表）
     */
    private Integer itemId;

    /**
     * 库存数量
     */
    private Integer quantity;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdated;
}

