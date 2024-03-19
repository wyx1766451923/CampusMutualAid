package com.example.ncmashd.controller;

import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.entity.User;
import com.example.ncmashd.service.UserService;
import com.example.ncmashd.uils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public JsonResult getUserInfo(Integer id){
        try{

            User user = userService.getById(id);
            user.setPassword("**");
            return JsonResult.success(user);
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }
}
