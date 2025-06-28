package net.luculent.trenddbmanage.warehouseflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryOrderItemResponse {

    private Integer id;

    private Integer itemId;

    private String itemName;

    private Integer quantity;

    private String unit;
}

