package com.example.ncmashd.controller;

import com.example.ncmashd.entity.Campusinfo;
import com.example.ncmashd.entity.Swiper;
import com.example.ncmashd.service.CampusinfoService;
import com.example.ncmashd.uils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campusinfo")
public class CampusinfoController {
    @Autowired
    private CampusinfoService campusinfoService;
    @RequestMapping("/getCampusinfos")
    public JsonResult getCampusinfos(){
        try {

            List<Campusinfo> list = campusinfoService.getCampusinfos();
            return JsonResult.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }
    @RequestMapping("/getCampusinfoById")
    public JsonResult getCampusinfoById(Integer id){
        try {

            Campusinfo campusinfo = campusinfoService.getById(id);
            return JsonResult.success(campusinfo);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }


}
