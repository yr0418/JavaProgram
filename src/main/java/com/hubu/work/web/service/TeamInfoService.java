package com.hubu.work.web.service;

import com.hubu.work.mybatis.mapper.TeamInfoMapper;
import com.hubu.work.mybatis.pojo.TeamInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName: TeamInfoService
 * @description: TeamInfo 对应的 Service 层
 * @author: 杨睿
 * @since: 2019-10-24 11:30
 **/
@Service
public class TeamInfoService extends BaseService<TeamInfo> {
    @Autowired
    TeamInfoMapper teamInfoMapper;

    public List<TeamInfo> selectUserTeam(String username){
        return teamInfoMapper.selectUserTeam(username);
    }
}
