package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.UserDetailInfo;
import com.hubu.work.utils.ImagesUtil;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserDetailInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "userDetailInfo")
public class UserDetailInfoController extends BaseController<UserDetailInfo> {
  @Autowired
  UserDetailInfoService userDetailInfoService;
  @Autowired
  ImagesUtil imagesUtil;

  @ApiOperation(value = "用户修改头像")
  @PostMapping(value = "uploadImg")
  public int uploadImg(MultipartFile file, String username){
    try {
      String path= imagesUtil.saveImage(file,username);
      return userDetailInfoService.UpdateUserImg(path,username);
    }catch (Exception e){
      return 0;
    }
  }

  @ApiOperation(value = "获取用户头像的相对地址")
  @PostMapping(value = "getUserImgPath")
  public String findImgPath(String username, HttpServletRequest request){
    String path=userDetailInfoService.findUserImg(username);
    //获取服务器地址，类似 http:localhost:8888
    String serverBasePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    return serverBasePath+"/"+path;
  }
}
