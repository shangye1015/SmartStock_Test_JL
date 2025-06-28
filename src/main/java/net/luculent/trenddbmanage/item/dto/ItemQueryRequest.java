package net.luculent.trenddbmanage.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * 查询物品分页请求参数
 * 支持名称模糊搜索和分类筛选
 *
 * @author shangye
 * @date 2025-06-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemQueryRequest {

    private String name;

    private Integer categoryId;

    @Min(1)
    private Integer page = 1;

    @Min(1)
    private Integer size = 10;
}

