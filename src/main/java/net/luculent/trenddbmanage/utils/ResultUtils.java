package net.luculent.trenddbmanage.utils;

import net.luculent.trenddbmanage.common.model.Result;

public class ResultUtils {
    public static <T> Result<T> loginSuccess(T data) {
        return Result.<T>builder().status(0).message("登录成功").data(data).build();
    }

    public static <T> Result<T> error(int code, String message) {
        return Result.<T>builder().status(code).message(message).build();
    }
}

