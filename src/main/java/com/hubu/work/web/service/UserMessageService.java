package com.hubu.work.web.service;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.mapper.UserMessageMapper;
import com.hubu.work.mybatis.pojo.UserMessage;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName UserMessageService
 * @description UserMessage Service 层
 *
 * @author 杨睿
 * @since 2019/9/21 17:00
 */
@Service
public class UserMessageService extends BaseService<UserMessage> {
  @Autowired
  UserMessageMapper userMessageMapper;

  @Override
  public int insert(UserMessage userMessage){
    return userMessageMapper.insert(userMessage);
  }

  public int readMessage(Long id){
    return userMessageMapper.readMessage(id);
  }

  public int getMessageReceiveCountWithType2AndType3(String username){
    return userMessageMapper.getMessageReceiveCountWithType2AndType3(username);
  }

  public int getMessageReceiveCountWithType2AndType3AndUnread(String username){
    return userMessageMapper.getMessageReceiveCountWithType2AndType3AndUnread(username);
  }
  public List<UserMessage> selectMessageReceiveWithType2AndRead(String username){
    return userMessageMapper.selectMessageReceiveWithType2AndRead(username);
  }

  public List<UserMessage> selectMessageReceiveWithType2AndUnread(String username){
    return userMessageMapper.selectMessageReceiveWithType2AndUnread(username);
  }

  public List<UserMessage> selectMessageReceiveWithType3AndRead(String username){
    return userMessageMapper.selectMessageReceiveWithType3AndRead(username);
  }

  public List<UserMessage> selectMessageReceiveWithType3AndUnread(String username){
    return userMessageMapper.selectMessageReceiveWithType3AndUnread(username);
  }
}
