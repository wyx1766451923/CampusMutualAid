package com.example.ncmashd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncmashd.entity.Comments;
import com.example.ncmashd.query.publishCommentQuery;

import java.util.Map;

public interface CommentsService extends IService<Comments> {
    Map<String, Object> publishComment(publishCommentQuery query);
}
