package com.example.ncmashd.controller;

import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.service.LostAndFoundService;
import com.example.ncmashd.uils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/LostAndFound")
public class LostAndFoundController {
    @Autowired
    private LostAndFoundService lostAndFoundService;
    @RequestMapping("/getLostAndFoundInfo")
    public JsonResult getLostAndFoundInfo(){
        try{
            List<LostAndFound> list = lostAndFoundService.list();
            return JsonResult.success(list);
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }

}
