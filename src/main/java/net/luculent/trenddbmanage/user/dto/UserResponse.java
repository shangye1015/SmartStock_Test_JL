package net.luculent.trenddbmanage.user.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Integer id;
    private String username;
    private String name;
    private String phone;
    private String department;
    private String position;
    private Integer age;
    private String gender;
    private Integer roleId;
    private String createdAt;
}

