package com.hubu.work.web.service;

import com.hubu.work.mybatis.mapper.UserMessageMapper;
import com.hubu.work.mybatis.pojo.UserMessage;
import com.hubu.work.utils.DateUtil;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName: UserMessageService
 * @description: UserMessage Service 层\
 *
 * @author: 杨睿
 * @since: 2019/9/21 17:00
 */
@Service
public class UserMessageService extends BaseService<UserMessage> {
    @Autowired
    UserMessageMapper userMessageMapper;

    @Autowired
    DateUtil dateUtil;

    public int readMessage(Long id) {
        return userMessageMapper.readMessage(id);
    }

    public int getMessageCountWithNotRead(String username) {
        return userMessageMapper.getMessageCountWithNotRead(username);
    }

    public int getMessageReceiveCountWithType2AndType3(String username) {
        return userMessageMapper.getMessageReceiveCountWithType2AndType3(username);
    }

    public int getMessageReceiveCountWithType2AndType3AndUnread(String username) {
        return userMessageMapper.getMessageReceiveCountWithType2AndType3AndUnread(username);
    }

    public List<UserMessage> selectMessageReceiveWithType2AndRead(String username) {
        return userMessageMapper.selectMessageReceiveWithType2AndRead(username);
    }

    public List<UserMessage> selectMessageReceiveWithType2AndUnread(String username) {
        return userMessageMapper.selectMessageReceiveWithType2AndUnread(username);
    }

    public List<UserMessage> selectMessageReceiveWithType3AndRead(String username) {
        return userMessageMapper.selectMessageReceiveWithType3AndRead(username);
    }

    public List<UserMessage> selectMessageReceiveWithType3AndUnread(String username) {
        return userMessageMapper.selectMessageReceiveWithType3AndUnread(username);
    }

    /**
     * 发送申请审核失败的消息给申请信息的发送者
     *
     * @param sender   该消息的发送者
     * @param receiver 该消息的接受者
     * @return 影响的行数
     */
    public int sendMessageWithAuditFail(String sender, String receiver) {
        UserMessage userMessage = new UserMessage();
        userMessage.setSender(sender);
        userMessage.setReceiver(receiver);
        userMessage.setDate(dateUtil.setTime());
        userMessage.setRead(0);
        userMessage.setType(2);
        userMessage.setContext("申请失败，请选择其他的活动在尝试一下吧");
        return userMessageMapper.insert(userMessage);
    }

    /**
     * 发送申请审核成功的消息给申请信息的发送者
     *
     * @param sender   该消息的发送者
     * @param receiver 该消息的接受者
     * @return 影响的行数
     */
    public int sendMessageWithAuditSuccess(String sender, String receiver) {
        UserMessage userMessage = new UserMessage();
        userMessage.setSender(sender);
        userMessage.setReceiver(receiver);
        userMessage.setDate(dateUtil.setTime());
        userMessage.setRead(0);
        userMessage.setType(3);
        userMessage.setContext("申请成功，赶快跟队友一起沟通交流吧");
        return userMessageMapper.insert(userMessage);
    }

    /**
     * 发送申请审核失败的消息给申请信息的发送者，失败的原因在于申请的组队信息被撤销
     *
     * @param sender   该消息的发送者
     * @param receiver 该消息的接受者
     * @return 影响的行数
     */
    public int sendMessageWithAuditFailByTeamNotValid(String sender, String receiver) {
        UserMessage userMessage = new UserMessage();
        userMessage.setSender(sender);
        userMessage.setReceiver(receiver);
        userMessage.setDate(dateUtil.setTime());
        userMessage.setRead(0);
        userMessage.setType(2);
        userMessage.setContext("申请的活动已被撤销，请申请其他的活动");
        return userMessageMapper.insert(userMessage);
    }

}
