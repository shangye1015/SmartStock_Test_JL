package net.luculent.trenddbmanage.warehouseflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryOrderQueryRequest {
    @NotNull(message = "页码不能为空")
    private Integer page;

    @NotNull(message = "每页条数不能为空")
    private Integer size;
}
