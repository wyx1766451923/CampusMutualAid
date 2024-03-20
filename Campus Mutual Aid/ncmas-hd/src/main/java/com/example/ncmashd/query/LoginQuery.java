package com.example.ncmashd.query;

import lombok.Data;

@Data
public class LoginQuery {
    private String username;
    private String password;
    private String avatar;
    private String nickname;
    private Integer Permissions;
}
