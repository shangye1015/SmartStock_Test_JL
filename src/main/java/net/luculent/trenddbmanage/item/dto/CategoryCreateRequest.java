package net.luculent.trenddbmanage.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
/**
 * 创建分类请求参数
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryCreateRequest {

    @NotBlank(message = "分类名称不能为空")
    private String name;

    private Integer sortOrder;

    private Integer status;
}

