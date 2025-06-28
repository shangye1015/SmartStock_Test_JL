package net.luculent.trenddbmanage.utils;

import net.luculent.trenddbmanage.common.model.Result;

/**
 * 结果工具类
 *
 * 提供构造统一 API 响应结果的静态方法，
 * 方便返回登录成功、通用成功、失败等标准响应。
 */
public class ResultUtils {

    /**
     * 构造登录成功响应
     *
     * @param data 登录成功后返回的数据（如token等）
     * @param <T>  返回数据类型
     * @return 封装好的登录成功结果对象
     */
    public static <T> Result<T> loginSuccess(T data) {
        return Result.<T>builder()
                .status(0)
                .message("登录成功")
                .data(data)
                .build();
    }

    /**
     * 构造通用成功响应，带返回数据
     *
     * @param data 返回数据
     * @param <T>  返回数据类型
     * @return 封装好的成功结果对象
     */
    public static <T> Result<T> success(T data) {
        return Result.<T>builder()
                .status(0)
                .message("成功")
                .data(data)
                .build();
    }

    /**
     * 构造通用成功响应，不带返回数据
     *
     * @param <T> 返回数据类型
     * @return 封装好的成功结果对象，data为null
     */
    public static <T> Result<T> success() {
        return Result.<T>builder()
                .status(0)
                .message("成功")
                .data(null)
                .build();
    }

    /**
     * 构造错误响应
     *
     * @param code    错误码
     * @param message 错误消息
     * @param <T>     返回数据类型
     * @return 封装好的错误结果对象
     */
    public static <T> Result<T> error(int code, String message) {
        return Result.<T>builder()
                .status(code)
                .message(message)
                .build();
    }
}
