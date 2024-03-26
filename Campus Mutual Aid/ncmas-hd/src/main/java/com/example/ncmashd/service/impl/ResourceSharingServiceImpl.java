package com.example.ncmashd.service.impl;

import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncmashd.entity.ResourceSharing;
import com.example.ncmashd.mapper.ResourceSharingMapper;
import com.example.ncmashd.query.ResourceSharingQuery;
import com.example.ncmashd.service.ResourceSharingService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ResourceSharingServiceImpl extends ServiceImpl<ResourceSharingMapper,ResourceSharing> implements ResourceSharingService {

    @Override
    public PageList<ResourceSharing> getResourceSharingPage(ResourceSharingQuery query) {
        Long total = baseMapper.getResourceSharingCount(query);
        List<ResourceSharing> list = baseMapper.getResourceSharingPage(query);

        return new PageList<ResourceSharing>(list,total);
    }
}
