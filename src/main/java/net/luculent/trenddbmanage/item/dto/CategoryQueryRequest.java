package net.luculent.trenddbmanage.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;


/**
 * 查询分类分页请求参数
 * 支持分类名称模糊搜索
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryQueryRequest {

    private String name;

    @Min(1)
    private Integer page = 1;

    @Min(1)
    private Integer size = 10;
}

