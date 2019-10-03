package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.Skt;

public interface SktMapper extends CustomMapper<Skt> {
    @Override
    public int insert (Skt skt);
}