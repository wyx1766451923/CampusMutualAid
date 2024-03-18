package com.example.ncmashd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.query.LostAndFoundQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LostAndFoundMapper extends BaseMapper<LostAndFound> {
    Long getLostAndFoundCount(LostAndFoundQuery query);

    List<LostAndFound> getLostAndFoundPage(LostAndFoundQuery query);

}
