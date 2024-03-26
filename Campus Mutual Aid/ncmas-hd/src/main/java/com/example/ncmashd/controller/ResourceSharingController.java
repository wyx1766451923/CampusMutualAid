package com.example.ncmashd.controller;

import com.baomidou.mybatisplus.core.metadata.PageList;
import com.example.ncmashd.entity.ResourceSharing;
import com.example.ncmashd.query.ResourceSharingQuery;
import com.example.ncmashd.service.ResourceSharingService;
import com.example.ncmashd.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/resourceSharing")
public class ResourceSharingController {
    @Autowired
    private ResourceSharingService resourceSharingService;

    @RequestMapping(value = "/getResourceSharingPage",method = RequestMethod.POST)
    public JsonResult getResourceSharingPage(@RequestBody ResourceSharingQuery query){
        try{

            PageList<ResourceSharing> pagelist = resourceSharingService.getResourceSharingPage(query);
            return JsonResult.success(pagelist.getRecords());
        }
        catch (Exception e){
            e.printStackTrace();
            return JsonResult.error("出现了一个问题，请联系管理员"+e.getMessage());
        }
    }

}
