package net.luculent.trenddbmanage.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDeleteRequest {
    @NotNull(message = "仓库ID不能为空")
    private Integer id;
}

