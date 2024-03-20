package com.example.ncmashd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncmashd.entity.Comments;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.mapper.LostAndFoundMapper;
import com.example.ncmashd.query.CommentQuery;
import com.example.ncmashd.query.LostAndFoundQuery;
import com.example.ncmashd.service.LostAndFoundService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class LostAndFoundServiceImpl extends ServiceImpl<LostAndFoundMapper, LostAndFound> implements LostAndFoundService {
    @Override
    public PageList<LostAndFound> getLostAndFoundPage(LostAndFoundQuery query) {
        Long total = baseMapper.getLostAndFoundCount(query);
        List<LostAndFound> list = baseMapper.getLostAndFoundPage(query);
        return new PageList<LostAndFound>(list,total);
    }
    @Override
    public Integer getLostAndFoundCounts(Integer type,String goodsName,String time){
        QueryWrapper<LostAndFound> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        if(StringUtils.hasText(goodsName)){
            wrapper.like("goodsName",goodsName);
        }
        if(StringUtils.hasText(time)){
            wrapper.eq("time",time);
        }

        Integer count = baseMapper.selectCount(wrapper);
        return count;
    }

    @Override
    public LostAndFound getLostAndFoundInfoById(Integer id) {
        LostAndFound laf = baseMapper.getLostAndFoundInfoById(id);
        return laf;
    }

    @Override
    public List<Comments> getLostAndFoundCommentsById(CommentQuery query) {
        List<Comments> list = baseMapper.getLostAndFoundCommentsById(query);
        return list;

    }

}
