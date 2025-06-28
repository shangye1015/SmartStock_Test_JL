package net.luculent.trenddbmanage.warehouseflow.entity;

import lombok.*;

/**
 * 出入库单子表实体类
 * <p>
 * 表示一张出入库单中的一条商品明细记录。
 * 一个订单可以有多条 item 明细。
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryOrderItem {

    /**
     * 主键 ID
     */
    private Integer id;

    /**
     * 所属出入库单 ID（外键）
     */
    private Integer orderId;

    /**
     * 商品 ID
     */
    private Integer itemId;

    /**
     * 商品数量（出入库数量）
     */
    private Integer quantity;
}

