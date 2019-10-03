package com.hubu.work.web.service;

import com.hubu.work.mybatis.mapper.SktMapper;
import com.hubu.work.mybatis.pojo.Skt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @moduleName SktService
 * @description skt对应的service层
 * @Author 刘江
 * @since 2019-10-03 15:43
 **/
@Service
public class SktService {
    @Autowired
    SktMapper sktMapper;
    public int insert (Skt skt){
        return sktMapper.insert(skt);
    }
}
