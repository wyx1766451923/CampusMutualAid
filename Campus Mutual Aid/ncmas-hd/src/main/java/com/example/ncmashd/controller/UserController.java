package com.example.ncmashd.controller;

import com.example.ncmashd.entity.User;
import com.example.ncmashd.query.LoginQuery;
import com.example.ncmashd.service.UserService;
import com.example.ncmashd.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult login(@RequestBody LoginQuery query){
        try{

            Map<String,Object> map = userService.login(query);
            return JsonResult.success(map);
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JsonResult register(@RequestBody LoginQuery query){
        try{

            Map<String,Object> map = userService.register(query);
            return JsonResult.success(map);
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }
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
    @RequestMapping(value = "/updateUserInfoById",method = RequestMethod.POST)
    public JsonResult updateUserInfoById(@RequestBody LoginQuery query){
        try{

            Map<String,Object> map = userService.updateUserInfoById(query);
            return JsonResult.success(map);
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }
    @RequestMapping(value = "/updateAvatarByid",method = RequestMethod.POST)
    public JsonResult updateAvatarByid(@RequestBody LoginQuery query){
        try{

            Map<String,Object> map = userService.updateAvatarByid(query);
            return JsonResult.success(map);
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }
    @RequestMapping(value = "/updatePasswordById",method = RequestMethod.POST)
    public JsonResult updatePasswordById(@RequestBody LoginQuery query){
        try{

            Map<String,Object> map = userService.updatePasswordById(query);
            return JsonResult.success(map);
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }
}
