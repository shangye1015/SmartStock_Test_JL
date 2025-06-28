package net.luculent.trenddbmanage.user.dao;

import net.luculent.trenddbmanage.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户数据访问接口
 *
 * 提供对用户表（t_user）的数据库操作方法，
 * 包括基于用户名和密码查询、根据ID查询、增删改查等。
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 匹配的用户对象，若不存在则返回null
     */
    @Select("SELECT * FROM t_user WHERE username = #{username} AND password = #{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户对象或null
     */
    User findByUsername(String username);

    /**
     * 根据用户ID查询用户
     *
     * @param id 用户ID
     * @return 用户对象或null
     */
    User findById(Integer id);

    /**
     * 动态插入用户信息（忽略null字段）
     *
     * @param user 用户实体
     */
    void insertSelective(User user);

    /**
     * 动态更新用户信息（忽略null字段）
     *
     * @param user 用户实体，必须包含ID
     */
    void updateSelective(User user);

    /**
     * 根据ID删除用户
     *
     * @param id 用户ID
     */
    void deleteById(Integer id);

    /**
     * 根据用户名模糊查询用户列表，支持分页
     *
     * @param username 用户名关键词
     * @param offset 分页偏移量
     * @param limit 每页条数限制
     * @return 用户列表
     */
    List<User> findByUsernameLike(@Param("username") String username, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据用户名模糊查询用户数量
     *
     * @param username 用户名关键词
     * @return 用户总数
     */
    int countByUsernameLike(@Param("username") String username);
}
