package net.luculent.trenddbmanage.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseQueryRequest {

    private String code;       // 精确查编号
    private String name;       // 模糊查名称
    private String manager;    // 模糊查负责人

    @Min(1)
    private Integer page = 1;

    @Min(1)
    private Integer size = 10;
}

