package net.luculent.trenddbmanage.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDeleteRequest {
    @NotNull(message = "物品ID不能为空")
    private Integer id;
}

