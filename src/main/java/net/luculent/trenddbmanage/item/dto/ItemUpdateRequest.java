package net.luculent.trenddbmanage.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 修改物品请求参数
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemUpdateRequest {

    @NotNull(message = "物品ID不能为空")
    private Integer id;

    private String sku;

    private String name;

    private Integer categoryId;

    private String specification;

    private String unit;

    private Double price;

    private Integer status;
}
