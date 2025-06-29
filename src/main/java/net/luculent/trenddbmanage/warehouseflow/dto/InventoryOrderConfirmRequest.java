package net.luculent.trenddbmanage.warehouseflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryOrderConfirmRequest {
    @NotNull(message = "单据ID不能为空")
    private Integer orderId;
}