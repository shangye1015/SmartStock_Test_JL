package net.luculent.trenddbmanage.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * 库存查询请求 DTO
 * 用于接收前端发起的库存明细分页查询参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryQueryRequest {

    /** 仓库名称（支持模糊搜索） */
    private String warehouseName;

    /** 物品名称（支持模糊搜索） */
    private String itemName;

    /** 当前页码，默认为 1，最小值为 1 */
    @Min(1)
    private Integer page = 1;

    /** 每页条数，默认为 10，最小值为 1 */
    @Min(1)
    private Integer size = 10;
}
