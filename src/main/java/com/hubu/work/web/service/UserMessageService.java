package com.hubu.work.web.service;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.mapper.UserMessageMapper;
import com.hubu.work.mybatis.pojo.UserMessage;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用模块名称：UserMessageService
 * 代码描述：UserMessage Service 层
 * @author：杨睿
 * @since 2019/9/21 17:00
 */
@Service
public class UserMessageService extends BaseService<UserMessage> {
  @Autowired
  UserMessageMapper userMessageMapper;

  public int readMessage(Long id){
    return userMessageMapper.readMessage(id);
  }

  public Page<UserMessage> selectUserMessageAcceptedWithType(String username,int type){
    return userMessageMapper.selectUserMessageAcceptedWithType(username, type);
  }

  public int getUserMessageNotReadCountWithType(String username,int type){
    return userMessageMapper.getUserMessageNotReadCountWithType(username,type);
  }
}
