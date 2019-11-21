package com.hubu.work.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hubu.work.mybatis.bean.MessageInfo;
import com.hubu.work.mybatis.pojo.UserMessage;
import com.hubu.work.utils.DateUtil;
import com.hubu.work.utils.PageBean;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.AuditInfoService;
import com.hubu.work.web.service.UserMessageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hubu.work.utils.Constant.CURRENT_PAGE;
import static com.hubu.work.utils.Constant.PAGE_SIZE;

/**
 * @moduleName: UserMessageController
 * @description: 操作用户消息的控制器
 * 
 * @author: 杨睿
 * @since: 2019/9/21 17:30
 */
@RestController
@RequestMapping(value = "userMessage")
public class UserMessageController extends BaseController<UserMessage> {
    @Autowired
    UserMessageService userMessageService;

    @Autowired
    AuditInfoService auditInfoService;

    @Autowired
    DateUtil dateUtil;

    @Override
    public int insert(@RequestBody UserMessage userMessage){
        userMessage.setDate(dateUtil.setTime());
        userMessage.setRead(0);
        return userMessageService.insert(userMessage);
    }

    @ApiOperation(value = "查询该用户是否有未读消息，包括接受到的消息和申请信息")
    @GetMapping(value = "getMessageCountWithNotRead")
    public boolean getMessageCountWithNotRead(String username){
        int count = userMessageService.getMessageCountWithNotRead(username) + auditInfoService.getAuditInfoCountWithReceiveAndUnread(username);
        return count > 0;
    }

    @ApiOperation(value = "设置信息阅读状态为：已读")
    @PostMapping(value = "readMessage")
    public int readMessage(Long id) {
        return userMessageService.readMessage(id);
    }

    @ApiOperation(value = "获取不同类型消息的未读数与总数")
    @GetMapping(value = "getMsgCountByType")
    public List<MessageInfo> getMsgCountByType(String username){
        //获取接收到的入队申请消息的未读数与总数
        List<MessageInfo> list = new ArrayList<>();

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setType(1);
        messageInfo.setSum(auditInfoService.getAuditInfoCountWithReceive(username));
        messageInfo.setUnreadCount(auditInfoService.getAuditInfoCountWithReceiveAndUnread(username));
        list.add(messageInfo);

        //获取接收到的申请审核结果消息的未读数与总数
        MessageInfo messageInfo1 = new MessageInfo();
        messageInfo1.setType(2);
        messageInfo1.setSum(userMessageService.getMessageReceiveCountWithType2AndType3(username));
        messageInfo1.setUnreadCount(userMessageService.getMessageReceiveCountWithType2AndType3AndUnread(username));
        list.add(messageInfo1);

        //获取发送出去的申请消息的未读数与总数
        MessageInfo messageInfo2 = new MessageInfo();
        messageInfo2.setType(3);
        messageInfo2.setSum(auditInfoService.getAuditInfoCountWithSend(username));
        messageInfo2.setUnreadCount(auditInfoService.getAuditInfoCountWithSendAndUnread(username));
        list.add(messageInfo2);

        return list;
    }

    @ApiOperation(value = "获取申请审核结果")
    @GetMapping(value = "getAuditResult")
    public List<UserMessage> getAuditResult(String username){
        List<UserMessage> list1 = userMessageService.selectMessageReceiveWithType2AndRead(username);
        List<UserMessage> list2 = userMessageService.selectMessageReceiveWithType3AndRead(username);
        List<UserMessage> list3 = userMessageService.selectMessageReceiveWithType2AndUnread(username);
        List<UserMessage> list4 = userMessageService.selectMessageReceiveWithType3AndUnread(username);
        List<UserMessage> result = new ArrayList<>();
        result.addAll(list4);result.addAll(list3);result.addAll(list2);result.addAll(list1);
        return result;
    }

}
