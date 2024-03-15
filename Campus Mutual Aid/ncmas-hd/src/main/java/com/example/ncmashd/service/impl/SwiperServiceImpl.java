package com.example.ncmashd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncmashd.entity.Swiper;
import com.example.ncmashd.mapper.SwiperMapper;
import com.example.ncmashd.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SwiperServiceImpl extends ServiceImpl<SwiperMapper,Swiper> implements SwiperService {
//    @Autowired
//    SwiperMapper swiperMapper;
//    @Override
//    public List<Swiper> findAll(){
//        return swiperMapper.findAll();
//    }
}
