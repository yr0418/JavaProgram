package com.hubu.work.controller;

import com.hubu.work.H2_JPA.pojo.User;
import com.hubu.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
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
}
