package net.luculent.trenddbmanage.common.enums;

/**
 * 出入库单据状态枚举
 *
 * 表示出入库单据的处理状态
 *
 * - PENDING：待处理（未确认）
 * - COMPLETED：已完成（库存已更新）
 *
 * 每个状态包含：
 * - code：存储在数据库中的值（如 PENDING）
 * - description：用于界面展示的中文描述
 *
 * @author shangye
 * @date 2025-06-28
 */
public enum InventoryOrderStatusEnums {

    /**
     * 待处理
     */
    PENDING("PENDING", "待处理"),

    /**
     * 已完成
     */
    COMPLETED("COMPLETED", "已完成");

    private final String code;
    private final String description;

    InventoryOrderStatusEnums(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 获取状态编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取状态描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 通过编码获取枚举
     */
    public static InventoryOrderStatusEnums fromCode(String code) {
        for (InventoryOrderStatusEnums status : values()) {
            if (status.code.equalsIgnoreCase(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("未知的状态编码: " + code);
    }
}


