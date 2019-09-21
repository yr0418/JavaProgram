package com.hubu.work.web.service;

import com.hubu.work.mybatis.mapper.UserMapper;
import com.hubu.work.mybatis.pojo.User;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User> {
  @Autowired
  UserMapper userMapper;

  public int findUser(User user){
    return userMapper.findUser(user);
  }

  public int findUsername(String username){
    return userMapper.findUsername(username);
  }

}
