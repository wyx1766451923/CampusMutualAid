package com.example.ncmashd.controller;

import com.example.ncmashd.uils.JsonResult;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
@RestController
public class UploadController {
    @Value("/static/img/avatar")
    private String avatarImgPath;
    @Value("/static/img/campusinfo")
    private String campusImgPath;
    @Value("/static/img/lostandfound")
    private String lostandfoundImgPath;
    @PostMapping("/upload")
    public JsonResult upload(MultipartFile file, HttpServletRequest request){
        try {

            String originalFilename = file.getOriginalFilename();
            //1.截取字符串，获得后缀名
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));

            //2.生成新的文件名称 要求永不重复 避免重复上传导致文件名称重复
            String filename = UUID.randomUUID().toString() + ext;

            String fileSavePath = "";
            String returnPath = "";
//            if(type == 1){
//                //产品图片
//                fileSavePath = projectImgPath;
//                returnPath = "project/" + filename;
//            }else if(type == 2){
//                //技师图片
//                fileSavePath = technicianImgPath;
//                returnPath = "technician/" + filename;
//            }else if(type == 3){
//                //用户资料头像
//                fileSavePath = userImgPath;
//                returnPath = "user/" + filename;
//            }
            fileSavePath = lostandfoundImgPath;
            returnPath = "/img/lostandfound/" + filename;

            //3.采用输出流将文件二进制数据输出到新文件名称对应的文件中
            //开发阶段需要将此文件存储到src/main/resources下和target/classes下，项目上线后就只需要存储到target/classes下
//开发路径
            String path1 = "G:/毕业设计/Campus Mutual Aid/ncmas-hd/src/main/resources" + fileSavePath;
            String path2 = "G:/cqutmrxmsx/mrhd/target/classes" + fileSavePath;

            //上线
//            String path1 = "c:/mrhd" + fileSavePath;
//            String path2 = "c:/mrhd/target/classes" + fileSavePath;

            File file1 = new File(path1);
            if(!file1.exists()){
                file1.mkdirs();     //如果文件夹不存在，则创建文件夹，并且父级也会一起创建
            }
            File file2 = new File(path2);
            if(!file2.exists()){
                file2.mkdirs();     //如果文件夹不存在，则创建文件夹，并且父级也会一起创建
            }

            file1 = new File(path1, filename);
            file2 = new File(path2, filename);

            IOUtils.copy(file.getInputStream(), new FileOutputStream(file1));
            IOUtils.copy(file.getInputStream(), new FileOutputStream(file2));
//            System.out.println(file1.getAbsolutePath());
//            System.out.println(file2.getAbsolutePath());
            return JsonResult.success(returnPath);
        } catch (IOException e) {
            e.printStackTrace();
            return JsonResult.error("文件上传失败！");
        }
    }
}
