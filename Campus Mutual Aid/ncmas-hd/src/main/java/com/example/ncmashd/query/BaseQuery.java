package com.example.ncmashd.query;

import lombok.Data;

@Data
public class BaseQuery {
    private Integer page = 0;
    private Integer size = 12;
}
