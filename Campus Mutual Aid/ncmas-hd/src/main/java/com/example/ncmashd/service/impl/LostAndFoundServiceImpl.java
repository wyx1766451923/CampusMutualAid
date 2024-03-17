package com.example.ncmashd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncmashd.entity.LostAndFound;
import com.example.ncmashd.mapper.LostAndFoundMapper;
import com.example.ncmashd.service.LostAndFoundService;
import org.springframework.stereotype.Service;

@Service
public class LostAndFoundServiceImpl extends ServiceImpl<LostAndFoundMapper, LostAndFound> implements LostAndFoundService {
}
