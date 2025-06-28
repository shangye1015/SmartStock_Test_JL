package net.luculent.trenddbmanage.user.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotEmpty(message = "登录账号不能为空")
    @Length(min = 4, max = 32, message = "账号长度为 4-32 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 32, message = "密码长度为 4-32 位")
    private String password;
}
