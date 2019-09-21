package com.hubu.work.web.service;

import com.hubu.work.mybatis.mapper.UserDetailInfoMapper;
import com.hubu.work.mybatis.pojo.UserDetailInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailInfoService extends BaseService<UserDetailInfo> {
  @Autowired
  UserDetailInfoMapper userDetailInfoMapper;

  public String findUserImg(String username){
    return userDetailInfoMapper.findUserImg(username);
  }

  public int UpdateUserImg(String userImgPath,  String username){
    return userDetailInfoMapper.UpdateUserImg(userImgPath,username);
  }
}
