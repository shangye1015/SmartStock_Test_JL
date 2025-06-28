package net.luculent.trenddbmanage.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {
    private Integer status;     // 0 = 成功，非0 = 业务错误  // TODO: 错误信息常量枚举
    private String message;   // 提示信息
    private T data;           // 返回数据
}

