package net.luculent.trenddbmanage.user.service.impl;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.exception.BusinessException;
import net.luculent.trenddbmanage.user.dao.UserMapper;
import net.luculent.trenddbmanage.user.dto.*;
import net.luculent.trenddbmanage.user.entity.User;
import net.luculent.trenddbmanage.user.service.UserService;
import net.luculent.trenddbmanage.common.model.PageResult;
import org.springframework.stereotype.Service;
import cn.hutool.core.bean.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户服务实现类
 * <p>
 * 负责用户的增删改查业务逻辑处理。
 * 使用 UserMapper 操作数据库。
 * 利用 Hutool 的 BeanUtil 进行 DTO 与 Entity 之间的属性复制。
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * 创建用户
     * <p>
     * 先判断用户名是否存在，存在则抛出业务异常；
     * 不存在则复制请求参数，设置默认状态并插入数据库。
     *
     * @param req 用户创建请求参数
     * @throws BusinessException 当用户名已存在时抛出
     */
    @Override
    public void createUser(UserCreateRequest req) {
        User exist = userMapper.findByUsername(req.getUsername());
        if (exist != null) {
            throw new BusinessException("用户名已存在");
        }
        User user = BeanUtil.copyProperties(req, User.class);
        user.setStatus(1); // 默认启用状态
        userMapper.insertSelective(user);
    }

    /**
     * 更新用户信息
     * <p>
     * 先检查用户是否存在，不存在则抛出异常；
     * 存在则复制请求参数并更新数据库。
     *
     * @param req 用户更新请求参数，必须包含ID
     * @throws BusinessException 当用户不存在时抛出
     */
    @Override
    public void updateUser(UserUpdateRequest req) {
        User exist = userMapper.findById(req.getId());
        if (exist == null) {
            throw new BusinessException("用户名不存在");
        }
        User user = BeanUtil.copyProperties(req, User.class);
        userMapper.updateSelective(user);
    }

    /**
     * 删除用户
     * <p>
     * 根据ID先查询用户是否存在，不存在则抛出异常；
     * 存在则调用Mapper删除。
     *
     * @param id 用户ID
     * @throws BusinessException 当用户不存在时抛出
     */
    @Override
    public void deleteUser(Integer id) {
        User exist = userMapper.findById(id);
        if (exist == null) {
            throw new BusinessException("用户名不存在");
        }
        userMapper.deleteById(id);
    }

    /**
     * 分页查询用户列表
     * <p>
     * 根据用户名模糊匹配，分页查询符合条件的用户列表和总数；
     * 并转换为UserResponse DTO返回。
     *
     * @param req 查询请求，包含用户名模糊条件、分页页码和大小
     * @return 分页结果，包含总记录数和当前页数据列表
     */
    @Override
    public PageResult<UserResponse> queryUsers(UserQueryRequest req) {
        int offset = (req.getPage() - 1) * req.getSize();
        List<User> list = userMapper.findByUsernameLike(req.getUsername(), offset, req.getSize());
        int total = userMapper.countByUsernameLike(req.getUsername());

        List<UserResponse> records = list.stream()
                .map(u -> BeanUtil.copyProperties(u, UserResponse.class))
                .collect(Collectors.toList());

        return new PageResult<>(total, records);
    }
}
