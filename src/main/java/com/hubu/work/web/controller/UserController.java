package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.User;
import com.hubu.work.utils.ImagesUtil;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController<User>{
  @Autowired
  UserService userService;


  @ApiOperation(value = "登陆，返回值： 1：登陆成功，2：密码错误，0：用户名不存在")
  @PostMapping(value = "login")
  public int login(@RequestBody User user){
    int login=userService.findUser(user);
    if (login==1){
      return 1;
    }else {
      int UserCount=userService.findUsername(user.getUsername());
      if (UserCount==1){
        return 2;
      }else {
        return 0;
      }
    }
  }


}
