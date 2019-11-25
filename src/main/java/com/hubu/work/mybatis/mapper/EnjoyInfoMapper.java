package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.pojo.EnjoyInfo;
import org.apache.ibatis.annotations.Param;

import javax.persistence.Id;

public interface EnjoyInfoMapper {
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
}