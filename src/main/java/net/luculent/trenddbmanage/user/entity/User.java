package net.luculent.trenddbmanage.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * 对应数据库中的用户表（t_user），
 * 包含用户的基本信息字段。
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户ID，主键，自增
     */
    private Long id;

    /**
     * 用户名，唯一
     */
    private String username;

    /**
     * 密码，经过加密存储
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 部门名称
     */
    private String department;

    /**
     * 职位名称
     */
    private String position;

    /**
     * 年龄，整数
     */
    private Integer age;

    /**
     * 性别，"男"或"女"
     */
    private String gender;

    /**
     * 角色ID，关联角色表
     */
    private Integer roleId;

    /**
     * 用户状态，通常用作启用/禁用标记
     */
    private Integer status;

    /**
     * 创建时间，格式为字符串（建议使用Date/LocalDateTime）
     */
    private String createdAt;
}
