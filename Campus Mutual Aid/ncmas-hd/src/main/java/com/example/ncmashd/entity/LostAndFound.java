package com.example.ncmashd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("lostandfound")
public class LostAndFound {
    private Integer id;
    private String goodsName;
    private String address;
    private String time;
    private String imageUrl;
    private String description;
    private String name;
    private String ContactInformation;

    private Integer userid;
    private Integer type;
}







