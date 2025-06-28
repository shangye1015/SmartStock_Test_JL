package net.luculent.trenddbmanage.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一接口响应封装类。
 * <p>
 * 该类用于封装接口的返回结果，包括状态码、提示信息和具体数据，
 * 统一规范接口响应格式，方便前后端统一处理。
 * </p>
 *
 * @param <T> 返回数据的类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {
    private Integer status;     // 0 = 成功，非0 = 业务错误  // TODO: 错误信息常量枚举
    private String message;   // 提示信息
    private T data;           // 返回数据
}

