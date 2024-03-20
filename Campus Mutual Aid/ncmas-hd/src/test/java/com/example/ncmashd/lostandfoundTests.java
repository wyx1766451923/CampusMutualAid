package com.example.ncmashd;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.entity.User;
import com.example.ncmashd.mapper.LostAndFoundMapper;
import com.example.ncmashd.query.LoginQuery;
import com.example.ncmashd.query.LostAndFoundQuery;
import com.example.ncmashd.service.LostAndFoundService;
import com.example.ncmashd.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import sun.security.util.Password;

@RunWith(SpringRunner.class)
@SpringBootTest
public class lostandfoundTests {
    @Autowired
    private UserService userService;
    @Test
    void test1(){
        LoginQuery query = new LoginQuery();
    query.setUsername("176645192");
        query.setNickname("11");
        query.setAvatar("1100");
        query.setPassword("123456");
        query.setPermissions(0);

    }

}
