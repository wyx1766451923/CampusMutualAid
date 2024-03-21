package com.example.ncmashd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncmashd.entity.User;
import com.example.ncmashd.query.LoginQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String username);

    Integer register(LoginQuery query);
}
