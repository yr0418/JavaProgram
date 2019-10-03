package com.hubu.work.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hubu.work.mybatis.pojo.UserMessage;
import com.hubu.work.utils.PageBean;
import com.hubu.work.web.common.BaseController;
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
 * @moduleName UserMessageController
 * @description 操作用户消息的控制器
 * 
 * @author 杨睿
 * @since 2019/9/21 17:30
 */
@RestController
@RequestMapping(value = "userMessage")
public class UserMessageController extends BaseController<UserMessage> {
    @Autowired
    UserMessageService userMessageService;

    @ApiOperation(value = "设置信息阅读状态为：已读")
    @PostMapping(value = "readMessage")
    public int readMessage(Long id) {
        return userMessageService.readMessage(id);
    }

    @ApiOperation(value = "查询用户收到的信息，包括已读，未读信息，注意消息的类型")
    @GetMapping(value = "selectUserMessagesWithType")
    public PageBean<UserMessage> selectUserMessagesWithType(@RequestParam String username,@RequestParam int type,
        @RequestParam(defaultValue = CURRENT_PAGE) int pageNum, @RequestParam(defaultValue = PAGE_SIZE) int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        Page<UserMessage> page = userMessageService.selectUserMessageAcceptedWithType(username,type);
        return new PageBean<>(page);
    }

    @ApiOperation(value = "获取用户未读消息的数量，第一个是 好友申请消息的数量，第二个是入队申请消息的数量")
    @GetMapping(value = "getMessageNotReadCount")
    public List<Integer> getMessageNotReadCount(String username) {
        /**
         * 使用 list 保存 两种消息类型的数量
         * 第一个是 好友申请消息的数量，第二个是入队申请消息的数量
         */
        List<Integer> list=new ArrayList<>();
        int type1 = userMessageService.getUserMessageNotReadCountWithType(username,1);
        list.add(type1);
        int type2 = userMessageService.getUserMessageNotReadCountWithType(username,2);
        list.add(type2);
        return list;
    }
}
