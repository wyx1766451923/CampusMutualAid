package com.example.ncmashd.controller;


import com.example.ncmashd.entity.Swiper;
import com.example.ncmashd.service.SwiperService;
import com.example.ncmashd.utils.JsonResult;
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
    public JsonResult getSwipers() {
        try {

            List<Swiper> list = swiperService.list();
            return JsonResult.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }

    }
}

