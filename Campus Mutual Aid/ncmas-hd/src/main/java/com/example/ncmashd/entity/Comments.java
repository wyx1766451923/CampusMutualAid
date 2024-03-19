package com.example.ncmashd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Comments {
    private Integer id;
    private Integer userid;
    private Integer postid;
    private String commentContent;
    private String publishTime;
    @TableField(exist = false)
    private User user;
}
