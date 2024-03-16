package com.example.ncmashd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncmashd.entity.Campusinfo;
import com.example.ncmashd.entity.Swiper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CampusinfoMapper extends BaseMapper<Campusinfo> {
    List<Campusinfo> getCampusinfos();

}
