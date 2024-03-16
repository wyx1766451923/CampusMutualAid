package com.example.ncmashd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncmashd.entity.Campusinfo;
import com.example.ncmashd.entity.Swiper;

import java.util.List;

public interface CampusinfoService extends IService<Campusinfo> {
    List<Campusinfo> getCampusinfos();

}
