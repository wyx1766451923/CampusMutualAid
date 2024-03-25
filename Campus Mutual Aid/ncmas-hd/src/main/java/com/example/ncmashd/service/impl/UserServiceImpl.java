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

    @Override
    public Map<String, Object> register(LoginQuery query) {

        User user = baseMapper.selectByUsername(query.getUsername());
        Map<String,Object> map = new HashMap<>();
        if(user != null){
            map.put("register","exist");
            return map;
        }else{
            Integer resId = baseMapper.register(query);
            map.put("register","ok");
            return map;
        }
    }

    @Override
    public Map<String, Object> updateUserInfoById(LoginQuery query) {
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setId(query.getId());
        user.setNickname(query.getNickname());
        Integer res = baseMapper.updateById(user);
        if(res<=0){
            map.put("update","error");
        }else{
            map.put("update","ok");
        }
        return map;
    }

    @Override
    public Map<String, Object> updateAvatarByid(LoginQuery query) {
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setId(query.getId());
        user.setAvatar(query.getAvatar());
        Integer res = baseMapper.updateById(user);
        if(res<=0){
            map.put("update","error");
        }else{
            map.put("update","ok");
        }
        return map;
    }

    @Override
    public Map<String, Object> updatePasswordById(LoginQuery query) {
        Map<String,Object> map = new HashMap<>();
        User user = baseMapper.selectById(query.getId());
        if(user.getPassword().equals(query.getPassword())){
            map.put("update","equal");
        }else{
            user.setId(query.getId());
            user.setPassword(query.getPassword());
            Integer res = baseMapper.updateById(user);
            if(res<=0){
                map.put("update","error");
            }else{
                map.put("update","ok");
            }
        }

        return map;
    }
}
