package net.luculent.trenddbmanage.user.dto;

import lombok.Data;

import javax.validation.constraints.Min;


@Data
public class UserQueryRequest {
    private String username;

    @Min(value = 1, message = "页码最小为1")
    private Integer page = 1;

    @Min(value = 1, message = "每页条数最小为1")
    private Integer size = 10;
}

