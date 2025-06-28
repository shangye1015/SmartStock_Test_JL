package net.luculent.trenddbmanage.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {
    private Integer id;
    private String code;
    private String name;
    private String address;
    private String manager;
    private String contactPhone;
    private Integer status;
    private String createdAt;
}

