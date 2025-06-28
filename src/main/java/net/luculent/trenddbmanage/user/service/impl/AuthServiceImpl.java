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

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    // TODO:可替换为缓存或数据库的 token 存储
    private final Map<String, String> tokenStore = new ConcurrentHashMap<>();

    @Override
    public LoginResponse login(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, password);
        if (user == null || !Objects.equals(user.getPassword(), password)) {
            throw new RuntimeException("用户名或密码错误"); // TODO：使用glob全局异常，暂时不写了
        }

        String token = TokenUtil.generateToken();
        tokenStore.put(token, username);

        return new LoginResponse(token, username);
    }

    public boolean validateToken(String token) {
        return tokenStore.containsKey(token);
    }
}

