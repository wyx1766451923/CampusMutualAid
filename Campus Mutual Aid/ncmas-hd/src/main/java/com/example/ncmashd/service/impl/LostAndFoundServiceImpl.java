package com.example.ncmashd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.mapper.LostAndFoundMapper;
import com.example.ncmashd.query.LostAndFoundQuery;
import com.example.ncmashd.service.LostAndFoundService;
import org.springframework.stereotype.Service;

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
    public Integer getLostAndFoundCounts(Integer type){
        QueryWrapper<LostAndFound> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        Integer count = baseMapper.selectCount(wrapper);
        return count;
    }

}
