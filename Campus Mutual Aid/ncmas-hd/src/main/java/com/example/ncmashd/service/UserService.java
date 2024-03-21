package com.example.ncmashd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncmashd.entity.User;
import com.example.ncmashd.query.LoginQuery;

import java.util.Map;

public interface UserService extends IService<User> {
    Map<String, Object> login(LoginQuery query);

    Map<String, Object> register(LoginQuery query);
}
