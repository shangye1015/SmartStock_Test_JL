package net.luculent.trenddbmanage.user.service;


import net.luculent.trenddbmanage.user.dto.UserCreateRequest;
import net.luculent.trenddbmanage.user.dto.UserQueryRequest;
import net.luculent.trenddbmanage.user.dto.UserResponse;
import net.luculent.trenddbmanage.user.dto.UserUpdateRequest;
import net.luculent.trenddbmanage.common.model.PageResult;

public interface UserService {
    void createUser(UserCreateRequest req);
    void updateUser(UserUpdateRequest req);
    void deleteUser(Integer id);
    PageResult<UserResponse> queryUsers(UserQueryRequest req);
}



