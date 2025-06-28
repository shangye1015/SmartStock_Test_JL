package net.luculent.trenddbmanage.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseResponse {

    private Integer id;
    private String code;
    private String name;
    private String address;
    private String manager;
    private String contactPhone;
    private Integer status;
    private String createdAt;
}

