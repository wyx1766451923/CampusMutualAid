package com.example.ncmashd.query;

import lombok.Data;

@Data
public class publishCommentQuery {
    private Integer id;
    private Integer userid;
    private Integer postid;
    private String commentContent;
    private String publishTime;
}
