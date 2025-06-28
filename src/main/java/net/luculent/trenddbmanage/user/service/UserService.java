package net.luculent.trenddbmanage.user.service;

import net.luculent.trenddbmanage.user.dto.UserCreateRequest;
import net.luculent.trenddbmanage.user.dto.UserQueryRequest;
import net.luculent.trenddbmanage.user.dto.UserResponse;
import net.luculent.trenddbmanage.user.dto.UserUpdateRequest;
import net.luculent.trenddbmanage.common.model.PageResult;

/**
 * 用户服务接口
 *
 * 定义用户的增删改查操作，
 * 负责用户数据的业务处理和分页查询功能。
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param req 用户创建请求参数，包含用户名、密码等信息
     */
    void createUser(UserCreateRequest req);

    /**
     * 更新用户信息
     *
     * @param req 用户更新请求参数，必须包含用户ID及需要更新的字段
     */
    void updateUser(UserUpdateRequest req);

    /**
     * 根据用户ID删除用户
     *
     * @param id 用户ID
     */
    void deleteUser(Integer id);

    /**
     * 分页查询用户列表
     *
     * 支持用户名模糊查询，返回分页结果。
     *
     * @param req 查询请求，包含用户名过滤条件、页码和页大小
     * @return 分页的用户响应列表
     */
    PageResult<UserResponse> queryUsers(UserQueryRequest req);
}
