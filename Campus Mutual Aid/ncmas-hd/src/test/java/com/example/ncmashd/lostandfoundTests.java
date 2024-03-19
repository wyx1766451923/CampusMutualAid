package com.example.ncmashd;

import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.mapper.LostAndFoundMapper;
import com.example.ncmashd.query.LostAndFoundQuery;
import com.example.ncmashd.service.LostAndFoundService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

@RunWith(SpringRunner.class)
@SpringBootTest
public class lostandfoundTests {
    @Autowired
    private LostAndFoundService lostAndFoundService;
    @Test
    void test1(){
        String time = "";
        boolean as = StringUtils.hasText(time);
        if(as){
            System.out.println(as);
        }

    }

}
