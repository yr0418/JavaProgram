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
     * 修改字段值：read=1，消息已读
     * @param id
     * @return int
     * 1：修改成功
     * 0：修改失败
     */
    int readMessage(@Param("id") Long id);

    /**
     * 查询用户接受到的消息,从后向前查询
     * @param username：用户名
     * @param type：消息类型，好友申请，入队申请。
     * @return Page<UserMessage>
     */
    Page<UserMessage> selectUserMessageAcceptedWithType(@Param("username") String username,@Param("type") int type);

    /**
     * 查询用户未读信息的数量
     * @param username：用户名
     * @param type: 消息类型：好友申请，入队申请
     * @return int
     */
    int getUserMessageNotReadCountWithType(@Param("username") String username,@Param("type") int type);
}