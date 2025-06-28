package net.luculent.trenddbmanage.login.controller;

import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.login.dto.LoginRequest;
import net.luculent.trenddbmanage.login.dto.LoginResponse;
import net.luculent.trenddbmanage.login.dto.Test;
import net.luculent.trenddbmanage.login.service.AuthService;
import net.luculent.trenddbmanage.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Result<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request.getUsername(), request.getPassword());
        return ResultUtils.loginSuccess(response);
    }

    @PostMapping("/test")
    public ResponseEntity<LoginResponse> test(@RequestBody Test request) {
        System.out.println("yes1");
        LoginResponse response = authService.login(request.getUsername(), request.getPassword());
        System.out.println("yes2");
        return ResponseEntity.ok(response);
    }



}



