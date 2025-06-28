package net.luculent.trenddbmanage.utils;

import java.util.UUID;

/**
 * Token 工具类
 *
 * 提供用于生成唯一令牌（token）的静态方法，适用于登录、认证等场景。
 */
public class TokenUtil {

    /**
     * 生成一个随机的、不带短横线的 UUID 字符串，作为 token 使用
     *
     * @return 唯一标识字符串（32位，不含连字符）
     */
    public static String generateToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
