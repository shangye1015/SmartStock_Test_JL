package net.luculent.trenddbmanage.user.service.impl;

import net.luculent.trenddbmanage.user.dao.UserMapper;
import net.luculent.trenddbmanage.user.dto.LoginResponse;
import net.luculent.trenddbmanage.user.entity.User;
import net.luculent.trenddbmanage.user.service.AuthService;
import net.luculent.trenddbmanage.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 权限认证服务实现类
 * <p>
 * 负责用户登录验证、token生成及简单的token校验。
 * <p>
 * TODO: token存储目前使用内存ConcurrentHashMap，生产环境应使用缓存或数据库持久化。
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    /**
     * token存储表，key为token，value为用户名
     * 目前为内存存储，线程安全的ConcurrentHashMap
     */
    private final Map<String, String> tokenStore = new ConcurrentHashMap<>();

    /**
     * 用户登录验证
     * <p>
     * 根据用户名和密码查询用户，
     * 若验证成功则生成token并保存，
     * 返回登录响应信息。
     *
     * @param username 用户名
     * @param password 明文密码
     * @return LoginResponse 包含token和用户名
     * @throws RuntimeException 登录失败时抛出（用户名或密码错误）
     */
    @Override
    public LoginResponse login(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, password);
        if (user == null || !Objects.equals(user.getPassword(), password)) {
            throw new RuntimeException("用户名或密码错误"); // TODO: 未来改为全局异常处理
        }

        // 生成随机token
        String token = TokenUtil.generateToken();
        // 存储token映射
        tokenStore.put(token, username);

        return new LoginResponse(token, username);
    }

    /**
     * 验证token有效性
     *
     * @param token 令牌字符串
     * @return true表示token有效，false表示无效或不存在
     */
    public boolean validateToken(String token) {
        return tokenStore.containsKey(token);
    }
}
