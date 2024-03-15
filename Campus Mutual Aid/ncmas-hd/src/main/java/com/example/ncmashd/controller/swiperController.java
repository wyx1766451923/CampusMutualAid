package com.example.ncmashd.controller;


import com.example.ncmashd.entity.Swiper;
import com.example.ncmashd.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/swiper")
public class swiperController {
    @Autowired
    private SwiperService swiperService;

    @RequestMapping("/getSwipers")
    public List<Swiper> getSwipers() {
        return swiperService.list();
    }
}

