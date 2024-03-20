package com.example.ncmashd.service;

import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncmashd.entity.Comments;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.query.CommentQuery;
import com.example.ncmashd.query.LostAndFoundQuery;

import java.util.List;

public interface LostAndFoundService extends IService<LostAndFound> {
    PageList<LostAndFound> getLostAndFoundPage(LostAndFoundQuery query);

    Integer getLostAndFoundCounts(Integer type,String goodsName,String time);

    LostAndFound getLostAndFoundInfoById(Integer id);

    List<Comments> getLostAndFoundCommentsById(CommentQuery query);
}
