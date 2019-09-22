package com.hubu.work.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hubu.work.mybatis.pojo.UserMessage;
import com.hubu.work.utils.PageBean;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserMessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.hubu.work.utils.Constant.CURRENT_PAGE;
import static com.hubu.work.utils.Constant.PAGE_SIZE;

/**
 * 应用模块名称：UserMessageController
 * 代码描述： 操作用户消息的控制器
 * @author：杨睿
 * @since 2019/9/21 17:30
 */
@RestController
@RequestMapping(value = "userMessage")
public class UserMessageController extends BaseController<UserMessage> {
  @Autowired
  UserMessageService userMessageService;

  @ApiOperation(value = "设置信息阅读状态为：已读")
  @PostMapping(value = "readMessage")
  public int readMessage(Long id){
    return userMessageService.readMessage(id);
  }

  @ApiOperation(value = "查询用户收到的信息，包括已读，未读信息")
  @GetMapping(value = "selectUserMessages")
  public PageBean<UserMessage> selectUserMessages(@RequestParam String username,
                                                  @RequestParam(defaultValue = CURRENT_PAGE) int pageNum,
                                                  @RequestParam(defaultValue = PAGE_SIZE) int pageSize){
    PageHelper.startPage(pageNum,pageSize,true);
    Page<UserMessage> page=userMessageService.selectUserMessageAccepted(username);
    return new PageBean<>(page);
  }

  @ApiOperation(value = "获取用户未读消息的数量")
  @GetMapping(value = "getMessageNotReadCount")
  public int getMessageNotReadCount(String username){
    return userMessageService.getUserMessageNotReadCount(username);
  }
}
