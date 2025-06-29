package net.luculent.trenddbmanage.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDeleteRequest {

    @NotNull(message = "分类ID不能为空")
    private Integer id;
}

