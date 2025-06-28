package net.luculent.trenddbmanage.user.service;

import net.luculent.trenddbmanage.user.dto.LoginResponse;

/**
 * 认证服务接口
 *
 * 提供用户登录相关的功能，如登录验证及返回登录信息。
 */
public interface AuthService {

    /**
     * 用户登录验证
     *
     * 根据用户名和密码进行身份校验，成功返回登录响应信息。
     * 失败时通常抛出异常（如用户名或密码错误）。
     *
     * @param username 用户名
     * @param password 明文密码
     * @return LoginResponse 登录成功后的返回数据（如token、用户名等）
     */
    LoginResponse login(String username, String password);
}
