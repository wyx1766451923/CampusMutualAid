package com.example.ncmashd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncmashd.entity.Comments;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.query.CommentQuery;
import com.example.ncmashd.query.LostAndFoundQuery;
import com.example.ncmashd.query.PublishLostAndFoundInfoQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LostAndFoundMapper extends BaseMapper<LostAndFound> {
    Long getLostAndFoundCount(LostAndFoundQuery query);

    List<LostAndFound> getLostAndFoundPage(LostAndFoundQuery query);

    LostAndFound getLostAndFoundInfoById(Integer id);

    List<Comments> getLostAndFoundCommentsById(CommentQuery query);

    Integer publishLostAndFoundInfo(PublishLostAndFoundInfoQuery query);
}
