package net.luculent.trenddbmanage.user.dao;

import net.luculent.trenddbmanage.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user WHERE username = #{username} AND password = #{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User findByUsername(String username);
    User findById(Integer id);
    void insertSelective(User user);
    void updateSelective(User user);
    void deleteById(Integer id);
    List<User> findByUsernameLike(@Param("username") String username, @Param("offset") int offset, @Param("limit") int limit);
    int countByUsernameLike(@Param("username") String username);

}
