package net.luculent.trenddbmanage.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id; // 编辑用户用

    @NotEmpty(message = "账号不能为空")
    @Length(min = 4, max = 16, message = "账号长度为 4-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字和字母")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 32, message = "密码长度为 4-32 位")
    private String password;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    private String phone;

    private String department;

    private String position;

    @Min(value = 0, message = "年龄不能为负数")
    private Integer age;

    @Pattern(regexp = "^(男|女)?$", message = "性别只能为男或女")
    private String gender;

    @NotNull(message = "角色ID不能为空")
    private Integer roleId;

    @Min(0)
    @Max(1)
    private Integer status;
}

