package com.example.ncmashd.query;

import lombok.Data;

@Data
public class PublishLostAndFoundInfoQuery {
    private Integer id;
    private String goodsName;
    private String address;
    private String time;
    private String imageUrl;
    private String description;
    private String name;
    private String contactInformation;

    private Integer userid;
    private Integer type;
}
