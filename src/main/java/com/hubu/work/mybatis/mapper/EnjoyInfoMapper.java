package com.hubu.work.mybatis.mapper;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.bean.QueryInfo;
import com.hubu.work.mybatis.pojo.EnjoyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @moduleName: EnjoyInfoMapper
 * @description: EnjoyInfo 对应的 mapper 层
 *
 * @author: 胡嘉兵
 */
public interface EnjoyInfoMapper extends CustomMapper<EnjoyInfo> {
    /**
     * 设置 valid 值为 0，组队信息失效
     * @param id 主键值
     * @return 影响的行数
     */
    int unValid(@Param("id") Long id);
    /**
     * 设置该活动的 剩余位置 -1
     * @param id 该活动的id
     * @return 影响的行数
     */
    int setLeftSizeDecrease(Long id);
    /**
     * 获取该活动的剩余位置
     * @param id 该活动的 id
     * @return 剩余人数
     */
    int getLeftSize(Long id);
    /**
     * 获取最新的与用户同城市的人发布的组队玩乐信息
     * @param city 用户所在的城市
     * @return Page
     */
    Page<EnjoyInfo> getEnjoyInfo(@Param("city") String city);
    /**
     * 获取用户发布的组队玩乐信息
     * @param username 用户名
     * @return Page
     */
    Page<EnjoyInfo> getEnjoyInfoWithUserIssue(@Param("username") String username);
    /**
     * 获取用户参加过的组队玩乐信息
     * @param ids 主键的集合
     * @return Page
     */
    Page<EnjoyInfo> getEnjoyInfoWithUserAttend(@Param("ids") List<Integer> ids);

    /**
     * 根据查询条件查询用户发布的组队玩乐信息
     * @param queryInfo 封装查询条件
     * @return Page
     */
    Page<EnjoyInfo> selectEnjoyInfoWithQueryInfo(QueryInfo queryInfo);
}