package com.example.ncmashd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncmashd.entity.Comments;
import com.example.ncmashd.query.publishCommentQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {
    Integer publishComment(publishCommentQuery query);
}
