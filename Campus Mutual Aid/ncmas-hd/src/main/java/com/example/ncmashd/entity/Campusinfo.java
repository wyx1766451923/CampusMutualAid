package com.example.ncmashd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("campusinfo")
public class Campusinfo {
    private Integer id;
    private String title;
    private String content;
    private String imageurl;
    private String releaseTime;
}
