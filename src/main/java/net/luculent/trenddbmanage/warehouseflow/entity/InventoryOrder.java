package net.luculent.trenddbmanage.warehouseflow.entity;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 出入库单主表实体类
 *
 * 用于表示一个完整的出库或入库单，支持记录类型、状态、操作人、备注等信息。
 * recordType 可选值：IN / OUT
 * status 可选值：PENDING（待处理）、COMPLETED（已完成）
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryOrder {

    /** 主键 ID */
    private Integer id;

    /** 单据编号（唯一） */
    private String orderCode;

    /** 类型：IN = 入库，OUT = 出库 */
    private String recordType;

    /** 所属仓库 ID */
    private Integer warehouseId;

    /** 操作人 */
    private String operator;

    /** 单据状态：PENDING / COMPLETED */
    private String status;

    /** 操作时间 */
    private LocalDateTime operationTime;

    /** 备注信息 */
    private String remark;
}
