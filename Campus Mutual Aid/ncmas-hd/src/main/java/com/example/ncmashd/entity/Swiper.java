package com.example.ncmashd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("swiper")
public class Swiper {
    private Integer id;
    private String imageurl;
}
