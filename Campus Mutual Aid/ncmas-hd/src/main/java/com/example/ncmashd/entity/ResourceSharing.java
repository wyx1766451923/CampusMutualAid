package com.example.ncmashd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("resourcesharing")
public class ResourceSharing {
    private Integer id;
    private String resourcename;
    private String contactinformation;
    private String access;
    private String description;
    private String resourcetype;
    private String imageUrl;
    private Integer userid;
    @TableField(exist = false)
    private User user;


}
