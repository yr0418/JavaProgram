package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.UserMessage;
import org.apache.ibatis.annotations.Param;

/**
 * 应用模块名称: UserMessageMapper
 * 代码描述:UserMessage 的 mapper 层
 * @author：杨睿
 */
public interface UserMessageMapper extends CustomMapper<UserMessage> {
    /**
     * 修改字段值：read=1
     * @param id
     * @return int
     * 1：修改成功
     * 0：修改失败
     */
    int readMessage(@Param("id") Long id);
}