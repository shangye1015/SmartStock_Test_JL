package net.luculent.trenddbmanage.warehouseflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryOrderResponse {

    private Integer id;

    private String orderCode;

    private String recordType; // IN or OUT

    private Integer warehouseId;

    private String warehouseName;

    private String operator;

    private String remark;

    private String status; // PENDING, COMPLETED

    private LocalDateTime operationTime;

    private List<InventoryOrderItemResponse> items;
}

