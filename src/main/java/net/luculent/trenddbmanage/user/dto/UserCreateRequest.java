package net.luculent.trenddbmanage.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 32, message = "用户名长度为4-32位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "用户名格式为数字和字母")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 4, max = 32, message = "密码长度为4-32位")
    private String password;

    @NotBlank(message = "姓名不能为空")
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

    @NotNull(message = "角色ID不能为空")
    private Integer roleId;
}

