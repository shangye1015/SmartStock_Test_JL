package net.luculent.trenddbmanage.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

/**
 * 创建物品请求参数
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCreateRequest {

    @NotBlank(message = "SKU不能为空")
    private String sku;

    @NotBlank(message = "物品名称不能为空")
    private String name;

    private Integer categoryId;

    private String specification;

    private String unit;

    @DecimalMin(value = "0.0", message = "价格不能为负数")
    private Double price;

    private Integer status;
}

