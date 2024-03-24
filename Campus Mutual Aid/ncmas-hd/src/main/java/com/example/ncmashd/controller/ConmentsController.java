package com.example.ncmashd.controller;

import com.example.ncmashd.query.publishCommentQuery;
import com.example.ncmashd.service.CommentsService;
import com.example.ncmashd.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class ConmentsController {
    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/publishComment",method = RequestMethod.POST)
    public JsonResult publishComment(@RequestBody publishCommentQuery query){
        try{

            Map<String,Object> map= commentsService.publishComment(query);
            return JsonResult.success(map);
        }
        catch (Exception e){
            e.printStackTrace();
            return  JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }

}
