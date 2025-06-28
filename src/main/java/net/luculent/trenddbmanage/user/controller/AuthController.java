package net.luculent.trenddbmanage.user.controller;

import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.user.dto.*;
import net.luculent.trenddbmanage.user.service.AuthService;
import net.luculent.trenddbmanage.user.service.UserService;
import net.luculent.trenddbmanage.utils.BeanUtils;
import net.luculent.trenddbmanage.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *  权限等最后全部接口开发完成在做
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login") //admin  encrypted_password
    public Result<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request.getUsername(), request.getPassword());
        return ResultUtils.loginSuccess(response);
    }

    @PostMapping("/test")
    public Result<LoginResponse> test(@RequestBody Test request) {
//        UserCreateRequest validRequest = UserCreateRequest.builder()
//                .username("john123")
//                .password("securePass1")
//                .name("张三q")
//                .phone("13812345678")
//                .department("仓储部")
//                .position("管理员")
//                .age(30)
//                .gender("男")
//                .roleId(1)
//                .build();
//
//
//        BeanUtils.getBean(UserService.class).createUser(validRequest);
//

//        UserCreateRequest invalidRequest = UserCreateRequest.builder()
//                .username("john@#")        // ❌ 包含非法字符
//                .password("123")           // ❌ 太短（小于 4）
//                .name("")                  // ❌ 不能为空
//                .phone("abc123")           // ❌ 非数字
//                .department("研发")         // ✅ 合法
//                .position("测试工程师")       // ✅ 合法
//                .age(-10)                  // ❌ 年龄为负数
//                .gender("未知")             // ❌ 不在“男/女”范围
//                .roleId(null)              // ❌ 不能为空
//                .build();
//        BeanUtils.getBean(UserService.class).createUser(invalidRequest);



        UserUpdateRequest updateRequest = new UserUpdateRequest();
        updateRequest.setId(13); // 设置要更新的用户ID
        updateRequest.setPassword("securePass1");
        updateRequest.setName("张三q");
        updateRequest.setPhone("13812345678");
        updateRequest.setDepartment("仓储部");
        updateRequest.setPosition("管理员update");
        updateRequest.setAge(30);
        updateRequest.setGender("男");
        updateRequest.setRoleId(1);
        BeanUtils.getBean(UserService.class).updateUser(updateRequest);

        System.out.println("yes2");
        return ResultUtils.success();
    }


}




