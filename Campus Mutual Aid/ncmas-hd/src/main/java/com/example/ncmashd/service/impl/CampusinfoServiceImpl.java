package com.example.ncmashd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncmashd.entity.Campusinfo;
import com.example.ncmashd.entity.Swiper;
import com.example.ncmashd.mapper.CampusinfoMapper;
import com.example.ncmashd.service.CampusinfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusinfoServiceImpl extends ServiceImpl<CampusinfoMapper, Campusinfo> implements CampusinfoService {
    @Override
    public List<Campusinfo> getCampusinfos() {
        return baseMapper.getCampusinfos();
    }

}
