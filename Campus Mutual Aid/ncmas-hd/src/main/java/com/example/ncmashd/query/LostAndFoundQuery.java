package com.example.ncmashd.query;

import lombok.Data;

@Data
public class LostAndFoundQuery {
    private Integer page = 0;
    private Integer size = 12;
    private Integer type = 0;
    private String goodsName;
    private String time;
}
