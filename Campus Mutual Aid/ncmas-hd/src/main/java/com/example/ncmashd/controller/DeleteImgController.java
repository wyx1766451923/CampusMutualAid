package com.example.ncmashd.controller;

import com.example.ncmashd.entity.Swiper;
import com.example.ncmashd.query.ImageQuery;
import com.example.ncmashd.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController

public class DeleteImgController{
    @RequestMapping(value = "/deleteimg",method = RequestMethod.POST)
    public JsonResult deleteimg(@RequestBody ImageQuery query){
        try {

            String resultInfo = null;
            String path = query.getPath();
            Integer type = query.getType();
            //System.out.println(path);///imctemp-rainy/2.jpg
            int lastIndexOf = path.lastIndexOf("/");
            String imgpath = path.substring(lastIndexOf + 1, path.length());
            if(type == 0){
                if(imgpath == "avatar1.png"){
                    resultInfo = "ok";
                }else{
                    imgpath = "G:/毕业设计/Campus Mutual Aid/ncmas-hd/img/avatar/" + imgpath;
                    //System.out.println(img_path);//输出测试一下文件路径是否正确
                    File file = new File(imgpath);
                    if (file.exists()) {//文件是否存在

                        if (file.delete()) {//存在就删了，返回1
                            resultInfo =  "ok";
                        } else {
                            resultInfo =  "err";
                        }
                    }
                }
            }
            //System.out.println(img_path);

            return JsonResult.success(resultInfo);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }

}
