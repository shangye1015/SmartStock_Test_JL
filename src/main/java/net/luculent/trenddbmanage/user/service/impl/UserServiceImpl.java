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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public void createUser(UserCreateRequest req) {
        User exist = userMapper.findByUsername(req.getUsername());
        if (exist != null) {
            throw new BusinessException("用户名已存在");
        }
        User user = BeanUtil.copyProperties(req, User.class);
        user.setStatus(1); // 默认启用
        userMapper.insertSelective(user);
    }

    @Override
    public void updateUser(UserUpdateRequest req) {
        User exist = userMapper.findById(req.getId());
        if (null == exist) {
            throw new BusinessException("用户名不存在");
        }
        User user = BeanUtil.copyProperties(req, User.class);
        userMapper.updateSelective(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User exist = userMapper.findById(id);
        if (null == exist) {
            throw new BusinessException("用户名不存在");
        }
        userMapper.deleteById(id);
    }

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

