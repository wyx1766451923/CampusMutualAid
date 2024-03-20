package com.example.ncmashd.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncmashd.entity.User;
import com.example.ncmashd.mapper.UserMapper;
import com.example.ncmashd.query.LoginQuery;
import com.example.ncmashd.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Override
    public Map<String, Object> login(LoginQuery query) {
        User user = baseMapper.selectByUsername(query.getUsername());
        Map<String,Object> map = new HashMap<>();
        if(user == null){
            map.put("login","noUser");
            return map;
        }
        if(!query.getPassword().equals(user.getPassword())){
            map.put("login","pwdErro");
            return map;
        }
        user.setPassword("**");
        map.put("login","ok");
        map.put("userinfo",user);
        return map;
    }
}
