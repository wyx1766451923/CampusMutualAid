package com.example.ncmashd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.mapper.LostAndFoundMapper;
import com.example.ncmashd.query.LostAndFoundQuery;
import com.example.ncmashd.service.LostAndFoundService;
import com.example.ncmashd.uils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/LostAndFound")
public class LostAndFoundController {
    @Autowired
    private LostAndFoundService lostAndFoundService;
    @RequestMapping(value="/getLostAndFoundPage",method = RequestMethod.POST)
    public JsonResult getLostAndFoundInfo(@RequestBody LostAndFoundQuery query){
        try{
            PageList<LostAndFound> pagelist = lostAndFoundService.getLostAndFoundPage(query);
            return JsonResult.success(pagelist.getRecords());
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }
    @RequestMapping(value="getLostAndFoundCounts",method = RequestMethod.GET)
    public JsonResult getLostAndFoundCounts(Integer type){
        try{

            Integer count = lostAndFoundService.getLostAndFoundCounts(type);
            return JsonResult.success(count);
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }

}
