package com.hubu.work.mybatis.mapper;

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

}