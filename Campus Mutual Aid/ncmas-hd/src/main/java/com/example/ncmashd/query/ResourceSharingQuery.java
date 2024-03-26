package com.example.ncmashd.query;

import lombok.Data;

@Data
public class ResourceSharingQuery {
    private Integer page = 0;
    private Integer size = 4;
    private Integer userid;
}
