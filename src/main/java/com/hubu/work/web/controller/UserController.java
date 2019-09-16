package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.User;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController<User> {
  @Autowired
  UserService userService;

  @GetMapping(value = "selectAll")
  public List<User> selectAll(){
    return userService.selectAll();
  }
}
