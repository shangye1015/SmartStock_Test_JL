package net.luculent.trenddbmanage.login.service;

import net.luculent.trenddbmanage.login.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(String username, String password);
}

