package com.example.ncmashd.query;

import lombok.Data;

@Data
public class CommentQuery {
    private Integer page = 0;
    private Integer size = 7;
    private Integer id;
}
