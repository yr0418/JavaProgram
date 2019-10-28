package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.TeamInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @moduleName: TeamInfoMapper
 * @description: TeamInfo 对应的 mapper 层
 *
 * @author: 杨睿
 */
public interface TeamInfoMapper extends CustomMapper<TeamInfo> {
    /**
     * 查用用户参与过的组队
     * @param username 用户名
     * @return List
     */
    List<TeamInfo> selectUserTeam(@Param("username") String username);
}