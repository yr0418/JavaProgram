package com.hubu.work.controller;

import com.hubu.work.mybatis.pojo.User;
import com.hubu.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping(value = "selectAll")
  public List<User> selectAll(){
    return userService.selectAll();
  }

  @PostMapping(value = "login")
  public int login(@RequestBody User user){
    return userService.login(user);
  }
}
