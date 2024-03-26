package com.example.ncmashd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.entity.ResourceSharing;
import com.example.ncmashd.query.ResourceSharingQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceSharingMapper extends BaseMapper<ResourceSharing> {
    List<ResourceSharing> getResourceSharingPage(ResourceSharingQuery query);

    Long getResourceSharingCount(ResourceSharingQuery query);
}
