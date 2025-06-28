package net.luculent.trenddbmanage.user.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDeleteRequest {

    @NotNull(message = "用户ID不能为空")
    private Integer id;
}


