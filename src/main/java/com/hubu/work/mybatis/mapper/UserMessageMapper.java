package com.hubu.work.mybatis.mapper;

import com.github.pagehelper.Page;
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

    /**
     * 查询用户接受到的消息
     * @param username：用户名
     * @return Page<UserMessage>
     */
    Page<UserMessage> selectUserMessageAccepted(String username);

    /**
     * 查询用户未读信息的数量
     * @param username：用户名
     * @return int
     */
    int getUserMessageNotReadCount(String username);
}