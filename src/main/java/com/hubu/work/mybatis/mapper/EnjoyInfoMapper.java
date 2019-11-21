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
}