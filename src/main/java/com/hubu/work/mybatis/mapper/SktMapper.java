package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.Skt;

import java.util.List;

public interface SktMapper extends CustomMapper<Skt> {
    @Override
    int insert (Skt skt);

    @Override
    List<Skt> selectAll();


}