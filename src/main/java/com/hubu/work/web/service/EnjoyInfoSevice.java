package com.hubu.work.web.service;

import com.hubu.work.mybatis.mapper.EnjoyInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @moduleName EnjoyInfoService
 * @description enjoy_info 对应的Service层
 *
 * @Author 胡嘉兵
 * @since 2019-11-21 17:04
 **/
@Service
public class EnjoyInfoSevice {
    @Autowired
    EnjoyInfoMapper enjoyInfoMapper;


    public int unValid(Long id){
        return enjoyInfoMapper.unValid(id);
    }
    public int setLeftSizeDecrease(Long id){ return enjoyInfoMapper.setLeftSizeDecrease(id); }
    public int getLeftSize(Long id){ return enjoyInfoMapper.getLeftSize(id); }
}
