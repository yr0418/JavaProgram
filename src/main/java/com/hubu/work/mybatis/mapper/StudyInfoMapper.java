package com.hubu.work.mybatis.mapper;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.bean.QueryInfo;
import com.hubu.work.mybatis.pojo.StudyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @moduleName: StudyInfoMapper
 * @description: StudyInfo 对应的 mapper层
 * @author: 刘江
 */
public interface StudyInfoMapper extends CustomMapper<StudyInfo> {

    /**
     * 根据主键，设置组队学习信息失效
     * @param id 主键
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
     * 查询最新发布的，与用户所在学校相同的线下组队学习
     * @param school 用户所在的学校
     * @return Page<StudyInfo>
     */
    Page<StudyInfo> getStudyInfoWithType1AndSchool(@Param("school") String school);

    /**
     * 查询最新发布的线上学习模式
     * @return Page<StudyInfo>
     */
    Page<StudyInfo> getStudyInfoWithType2();

    /**
     * 根据查询条件查询组队学习信息
     * @param queryInfo 封装查询条件
     * @return Page<StudyInfo>
     */
    Page<StudyInfo> selectStudyInfoWithQueryInfo(QueryInfo queryInfo);

    /**
     * 查询用户发布的组队学习信息
     * @param username 用户名
     * @return Page
     */
    Page<StudyInfo> getStudyInfoWithUserIssue(@Param("username") String username);

    /**
     * 查询用户参加的组队学习信息
     * @param ids 主键集
     * @return Page
     */
    Page<StudyInfo> getStudyInfoWithUserAttend(@Param("ids") List<Integer> ids);


}