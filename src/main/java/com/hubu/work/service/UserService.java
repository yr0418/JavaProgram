package com.hubu.work.service;

import com.hubu.work.mybatis.mapper.UserMapper;
import com.hubu.work.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  UserMapper userMapper;

  public List<User> selectAll(){
    return userMapper.selectAll();
  }
}
