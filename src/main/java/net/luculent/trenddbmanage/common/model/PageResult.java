package net.luculent.trenddbmanage.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果封装类。
 * <p>
 * 用于封装分页查询结果，包括总记录数和当前页的数据列表，
 * 方便前端进行分页展示和处理。
 * </p>
 *
 * @param <T> 记录的数据类型
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Integer total;
    private List<T> records;
}


