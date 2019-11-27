package com.hubu.work.web.service;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.bean.QueryInfo;
import com.hubu.work.mybatis.mapper.EnjoyInfoMapper;
import com.hubu.work.mybatis.pojo.EnjoyInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName EnjoyInfoService
 * @description enjoy_info 对应的Service层
 *
 * @Author 胡嘉兵
 * @since 2019-11-21 17:04
 **/
@Service
public class EnjoyInfoSevice extends BaseService<EnjoyInfo> {
    @Autowired
    EnjoyInfoMapper enjoyInfoMapper;


    public int unValid(Long id)
    { return enjoyInfoMapper.unValid(id); }
    public int setLeftSizeDecrease(Long id)
    { return enjoyInfoMapper.setLeftSizeDecrease(id); }
    public int getLeftSize(Long id)
    { return enjoyInfoMapper.getLeftSize(id); }
    public Page<EnjoyInfo> getEnjoyInfo(String city)
    { return enjoyInfoMapper.getEnjoyInfo(city); }
    public Page<EnjoyInfo> getEnjoyInfoWithUserIssue(String username)
    { return enjoyInfoMapper.getEnjoyInfoWithUserIssue(username); }
}
