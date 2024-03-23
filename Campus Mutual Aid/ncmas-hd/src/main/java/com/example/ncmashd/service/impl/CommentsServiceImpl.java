package com.example.ncmashd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncmashd.entity.Comments;
import com.example.ncmashd.mapper.CommentsMapper;
import com.example.ncmashd.query.publishCommentQuery;
import com.example.ncmashd.service.CommentsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper,Comments> implements CommentsService {

    @Override
    public Map<String, Object> publishComment(publishCommentQuery query) {
        Map<String,Object> map = new HashMap<>();
        Integer resid = baseMapper.publishComment(query);
        if(resid > 0){
            map.put("publishComment","ok");
        }else{
            map.put("publishComment","error");
        }
        return map;
    }
}
