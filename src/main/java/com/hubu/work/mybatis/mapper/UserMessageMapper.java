package com.hubu.work.mybatis.mapper;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.UserMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 杨睿
 * @moduleName UserMessageMapper
 * @description UserMessage 的 mapper 层
 */
public interface UserMessageMapper extends CustomMapper<UserMessage> {
    /**
     * 插入数据
     *
     * @param userMessage UserMessage对象
     * @return int
     */
    @Override
    int insert(UserMessage userMessage);

    /**
     * 修改字段值：read=1，消息已读
     *
     * @param id
     * @return int
     * 1：修改成功
     * 0：修改失败
     */
    int readMessage(@Param("id") Long id);

    /**
     * 查询用户接受到的申请审核结果信息的总数
     *
     * @param username 用户名
     * @return int
     */
    int getMessageReceiveCountWithType2AndType3(@Param("username") String username);

    /**
     * 查询用户接受到的申请审核结果消息其未读的消息的总数
     *
     * @param username 用户名
     * @return int
     */
    int getMessageReceiveCountWithType2AndType3AndUnread(String username);

    /**
     * 查询用户接受到的申请审核失败且未读的消息
     *
     * @param username 用户名
     * @return List
     */
    List<UserMessage> selectMessageReceiveWithType2AndUnread(@Param("username") String username);

    /**
     * 查询用户接受到的申请审核失败且已读的消息
     * @param username 用户名
     * @return List
     */
    List<UserMessage> selectMessageReceiveWithType2AndRead(@Param("username") String username);

    /**
     * 查询用户接受到的申请审核成功且未读的消息
     *
     * @param username 用户名
     * @return List
     */
    List<UserMessage> selectMessageReceiveWithType3AndUnread(@Param("username") String username);

    /**
     * 查询用户接受到的申请审核成功且已读的消息
     * @param username 用户名
     * @return List
     */
    List<UserMessage> selectMessageReceiveWithType3AndRead(@Param("username") String username);


}