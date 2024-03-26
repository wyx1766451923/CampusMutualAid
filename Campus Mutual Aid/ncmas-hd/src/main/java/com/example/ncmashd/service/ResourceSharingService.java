package com.example.ncmashd.service;

import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncmashd.entity.ResourceSharing;
import com.example.ncmashd.query.ResourceSharingQuery;

public interface ResourceSharingService extends IService<ResourceSharing> {
    PageList<ResourceSharing> getResourceSharingPage(ResourceSharingQuery query);
}
