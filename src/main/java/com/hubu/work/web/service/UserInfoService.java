package com.hubu.work.web.service;

import com.hubu.work.mybatis.bean.User;
import com.hubu.work.mybatis.bean.UserSimpleInfo;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.pojo.UserInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @moduleName UserInfoService
 * @description UserInfo 的 Service 层
 *
 * @author 杨睿
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

  /**
   * 查询用户所在的学校
   * @param username 用户名
   * @return 用户所在的学校
   */
  public String findUserSchool(String username){
    return userInfoMapper.findUserSchool(username);
  }

  /**
   *查询用户所在的城市
   * @param username
   * @return
   */
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

  public int online(String username){
    return userInfoMapper.online(username);
  }

  public int outline(String username){
    return userInfoMapper.outline(username);
  }

  public UserSimpleInfo getUserSimpleInfo(String username){
    return userInfoMapper.getUserSimpleInfo(username);
  }

}
