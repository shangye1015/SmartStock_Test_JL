package net.luculent.trenddbmanage.user.controller;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.Result;
import net.luculent.trenddbmanage.user.dto.*;
import net.luculent.trenddbmanage.user.service.UserService;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户管理接口控制器
 * <p>
 * 提供用户的增删改查（CRUD）相关API，包括创建用户、更新用户信息、
 * 删除用户及分页查询用户列表。
 * </p>
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/create")
    public Result<Void> createUser(@Valid @RequestBody UserCreateRequest req) {
        userService.createUser(req);
        return ResultUtils.success();
    }

    @PostMapping("/update")
    public Result<Void> updateUser(@Valid @RequestBody UserUpdateRequest req) {
        userService.updateUser(req);
        return ResultUtils.success();
    }

    @PostMapping("/delete")
    public Result<Void> deleteUser(@Valid @RequestBody UserDeleteRequest req) {
        userService.deleteUser(req.getId());
        return ResultUtils.success();
    }


    @PostMapping("/list")
    public Result<PageResult<UserResponse>> listUsers(@Valid @RequestBody UserQueryRequest req) {
        PageResult<UserResponse> result = userService.queryUsers(req);
        return ResultUtils.success(result);
    }
}

