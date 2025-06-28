package net.luculent.trenddbmanage.user.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserUpdateRequest {
    @NotNull(message = "用户ID不能为空")
    private Integer id;

    @Size(min = 4, max = 32, message = "密码长度为4-32位")
    private String password;

    @Size(max = 64, message = "姓名长度不能超过64位")
    private String name;

    @Pattern(regexp = "^$|^\\+?[0-9\\-]{7,15}$", message = "电话格式不正确")
    private String phone;

    @Size(max = 64, message = "部门长度不能超过64位")
    private String department;

    @Size(max = 64, message = "职位长度不能超过64位")
    private String position;

    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 150, message = "年龄不能超过150")
    private Integer age;

    @Pattern(regexp = "^$|^(男|女)$", message = "性别只能是“男”或“女”")
    private String gender;

    private Integer roleId;
}

