package com.hubu.work.web.service;

import com.hubu.work.mybatis.bean.User;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.pojo.UserInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 应用模块名称: UserInfoService
 * 代码描述: UserInfo 的 Service 层
 * @author：杨睿
 */
@Service
public class UserInfoService extends BaseService<UserInfo> {
  @Autowired
  UserInfoMapper userInfoMapper;

  public String findUserImg(String username) {
    return userInfoMapper.findUserImg(username);
  }

  public int updateUserImg(String userImgPath, String username) {
    return userInfoMapper.updateUserImg(userImgPath, username);
  }

  public int findUser(User user) {
    return userInfoMapper.findUser(user);
  }

  public int findUsername(String username) {
    return userInfoMapper.findUsername(username);
  }

  public String findUserCity(String username) {
    return userInfoMapper.findUserCity(username);
  }

  public int findUserNickname(String nickname) {
    return userInfoMapper.findUserNickname(nickname);
  }

  public int updateUserPersonalizedSignature(String personalizedSignature, String username) {
    return userInfoMapper.updateUserPersonalizedSignature(personalizedSignature, username);
  }

  @Override
  public int update(UserInfo userInfo){
    return userInfoMapper.update(userInfo);
  }

  public UserInfo getUserInfo(String username){
    return userInfoMapper.getUserInfo(username);
  }
}
