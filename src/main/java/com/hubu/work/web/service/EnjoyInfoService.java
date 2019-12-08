package com.hubu.work.web.service;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.bean.QueryInfo;
import com.hubu.work.mybatis.mapper.EnjoyInfoMapper;
import com.hubu.work.mybatis.pojo.EnjoyInfo;
import com.hubu.work.mybatis.pojo.StudyInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName: EnjoyInfoService
 * @description: EnjoyInfo 对应的 Service层
 * @author: 胡嘉兵
 * @since: 2019-10-23 16:43
 **/
@Service
public class EnjoyInfoService extends BaseService<EnjoyInfo> {
    @Autowired
    EnjoyInfoMapper enjoyInfoMapper;

    public Page<EnjoyInfo> getEnjoyInfo(String city){
        return enjoyInfoMapper.getEnjoyInfo(city);
    }

    public Page<EnjoyInfo> selectEnjoyInfoWithQueryInfo(QueryInfo queryInfo){
        return enjoyInfoMapper.selectEnjoyInfoWithQueryInfo(queryInfo);
    }

    public Page<EnjoyInfo> getEnjoyInfoWithUserIssue(String username){
        return enjoyInfoMapper.getEnjoyInfoWithUserIssue(username);
    }

    public Page<EnjoyInfo> getEnjoyInfoWithUserAttend(List<Integer> ids){
        return enjoyInfoMapper.getEnjoyInfoWithUserAttend(ids);
    }

    public int unValid(Long id){
        return enjoyInfoMapper.unValid(id);
    }

    public int setLeftSizeDecrease(Long id){
        return enjoyInfoMapper.setLeftSizeDecrease(id);
    }

    public int getLeftSize(Long id){
        return enjoyInfoMapper.getLeftSize(id);
    }

}
