package net.luculent.trenddbmanage.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 仓库实体类
 *
 * 用于表示仓库表中的一条记录，通常与数据库的 t_warehouse 表对应。
 * 包含仓库的编号、名称、地址、负责人、联系电话、状态及创建时间等字段。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {

    /**
     * 主键 ID，自增
     */
    private Integer id;

    /**
     * 仓库编号，唯一标识一个仓库
     */
    private String code;

    /**
     * 仓库名称
     */
    private String name;

    /**
     * 仓库地址
     */
    private String address;

    /**
     * 负责人姓名
     */
    private String manager;

    /**
     * 联系电话（可用于仓库联系）
     */
    private String contactPhone;

    /**
     * 状态标识（0=禁用，1=启用等）
     */
    private Integer status;

    /**
     * 创建时间（字符串格式，建议后续改为 LocalDateTime）
     */
    private String createdAt;
}
