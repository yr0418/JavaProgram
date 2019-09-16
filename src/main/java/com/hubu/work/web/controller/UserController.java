package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.User;
import com.hubu.work.utils.ImagesUtil;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController<User> {
  @Autowired
  ImagesUtil imagesUtil;
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

  @ApiOperation(value = "用户修改头像")
  @PostMapping(value = "uploadImg")
  public int uploadImg(MultipartFile file,String username){
    try {
      String path= imagesUtil.saveImage(file,username);
      return userService.updateUserImg(path,username);
    }catch (Exception e){
      return 0;
    }
  }

  @ApiOperation(value = "获取用户头像的相对地址")
  @PostMapping(value = "getUserImgPath")
  public String findImgPath(String username, HttpServletRequest request){
    String path=userService.findImgPath(username);
    //获取服务器地址，类似 http:localhost:8888
    String serverBasePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    return serverBasePath+"/"+path;
  }
}
