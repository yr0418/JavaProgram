package com.hubu.work.mybatis.mapper;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.bean.QueryInfo;
import com.hubu.work.mybatis.pojo.StudyInfo;
import org.apache.ibatis.annotations.Param;

public interface StudyInfoMapper {
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
}
