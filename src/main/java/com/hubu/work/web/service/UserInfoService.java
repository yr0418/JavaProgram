package com.hubu.work.web.service;

import com.hubu.work.mybatis.bean.User;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.pojo.UserInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService extends BaseService<UserInfo> {
  @Autowired
  UserInfoMapper userInfoMapper;

  public String findUserImg(String username){
    return userInfoMapper.findUserImg(username);
  }

  public int UpdateUserImg(String userImgPath,  String username){
    return userInfoMapper.UpdateUserImg(userImgPath,username);
  }

  public int findUser(User user){
    return userInfoMapper.findUser(user);
  }

  public int findUsername(String username){
    return userInfoMapper.findUsername(username);
  }

  public String findUserCity(String username){
    return userInfoMapper.findUserCity(username);
  }
}
