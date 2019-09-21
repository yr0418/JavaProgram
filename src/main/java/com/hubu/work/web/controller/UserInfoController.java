package com.hubu.work.web.controller;

import com.hubu.work.mybatis.bean.User;
import com.hubu.work.mybatis.pojo.UserInfo;
import com.hubu.work.utils.ImagesUtil;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
/**
 * 应用模块名称: UserInfoController
 * 代码描述:提供操作用户信息的控制器
 * @author：杨睿
 */
@RestController
@RequestMapping(value = "userInfo")
public class UserInfoController extends BaseController<UserInfo> {
  @Autowired
  UserInfoService userInfoService;
  @Autowired
  ImagesUtil imagesUtil;

  @ApiOperation(value = "用户修改头像")
  @PostMapping(value = "uploadImg")
  public int uploadImg(MultipartFile file, String username) {
    try {
      String path = imagesUtil.saveImage(file, username);
      return userInfoService.updateUserImg(path, username);
    } catch (Exception e) {
      return 0;
    }
  }

  @ApiOperation(value = "获取用户头像的相对地址")
  @PostMapping(value = "getUserImgPath")
  public String findImgPath(String username, HttpServletRequest request) {
    String path = userInfoService.findUserImg(username);
    //获取服务器地址，类似 http:localhost:8888
    String serverBasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    return serverBasePath + "/" + path;
  }

  @ApiOperation(value = "登陆接口，1：登陆成功，0：登陆失败，2：该用户名未注册")
  @PostMapping(value = "login")
  public int login(@RequestBody User user) {
    int count = userInfoService.findUser(user);
    if (count == 1) {
      return 1;
    } else {
      int username = userInfoService.findUsername(user.getUsername());
      if (username == 1) {
        return 2;
      } else {
        return 0;
      }
    }
  }

  @Override
  public int insert(UserInfo userInfo) {
    int usernameCount = userInfoService.findUsername(userInfo.getUsername());
    int nicknameCount = userInfoService.findUserNickname(userInfo.getNickname());
    if (usernameCount == 1) {
      return 0;
    } else if (usernameCount == 0 && nicknameCount == 1) {
      return 2;
    } else {
      return userInfoService.insert(userInfo);
    }
  }


}
