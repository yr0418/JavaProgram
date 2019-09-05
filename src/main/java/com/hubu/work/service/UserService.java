package com.hubu.work.service;

import com.hubu.work.H2_JPA.dao.UserDao;
import com.hubu.work.H2_JPA.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  UserDao userDao;

  public List<User> selectAll(){
    return userDao.selectAll();
  }
}
