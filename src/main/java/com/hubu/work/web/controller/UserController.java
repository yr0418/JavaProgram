package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.User;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @ApiOperation(value = "登陆")
  @PostMapping(value = "login")
  public int login(@RequestBody User user){
    return userService.findUser(user);
  }
}
