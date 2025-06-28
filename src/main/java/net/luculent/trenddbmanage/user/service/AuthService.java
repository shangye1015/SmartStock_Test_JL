package net.luculent.trenddbmanage.user.service;

import net.luculent.trenddbmanage.user.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(String username, String password);
}

