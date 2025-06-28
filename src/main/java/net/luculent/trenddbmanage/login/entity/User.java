package net.luculent.trenddbmanage.login.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String department;
    private String position;
    private Integer age;
    private String gender;
    private Integer roleId;
    private Integer status;
    private String createdAt;
}



