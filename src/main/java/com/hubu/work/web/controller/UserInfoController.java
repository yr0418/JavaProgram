package com.hubu.work.web.controller;

import com.hubu.work.mybatis.bean.User;
import com.hubu.work.mybatis.pojo.UserInfo;
import com.hubu.work.utils.ImagesUtil;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @moduleName UserInfoController
 * @description 提供操作用户信息的控制器
 * 
 * @author 杨睿
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
        // 获取服务器地址，类似 http:localhost:8888
        String serverBasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        return serverBasePath + "/" + path;
    }

    @ApiOperation(value = "获取 WebSocket 的路径")
    @GetMapping(value = "getWebSocketPath")
    public String getWebSocketPath(HttpServletRequest request){
        String serverBasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        serverBasePath= serverBasePath.replace("https","ws").replace("http","ws");
        return serverBasePath+"/webSocket";
    }

    @ApiOperation(value = "登陆接口，1：登陆成功，2：该用户名未注册，3：密码错误")
    @PostMapping(value = "login")
    public int login(@RequestBody User user) {
        int count = userInfoService.findUser(user);
        if (count == 1) {
            return 1;
        } else {
            int username = userInfoService.findUsername(user.getUsername());
            if (username == 1) {
                return 3;
            } else {
                return 2;
            }
        }
    }

    @Override
    @ApiOperation(value = "插入用户信息，用于注册，需保证用户名与昵称是唯一值。返回值：1：注册成功，3：用户名已被使用，2：昵称已被使用")
    public int insert(UserInfo userInfo) {
        int usernameCount = userInfoService.findUsername(userInfo.getUsername());
        int nicknameCount = userInfoService.findUserNickname(userInfo.getNickname());
        if (usernameCount == 1) {
            return 3;
        } else if (usernameCount == 0 && nicknameCount == 1) {
            return 2;
        } else {
            return userInfoService.insert(userInfo);
        }
    }

    @Override
    @ApiOperation(value = "修改数据，只会修改传入的属性值对应的字段")
    public int update(UserInfo userInfo) {
        return userInfoService.update(userInfo);
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping(value = "getUserInfo")
    public UserInfo getUserInfo(String username) {
        return userInfoService.getUserInfo(username);
    }

    @ApiOperation(value = "修改用户个性签名")
    @PostMapping(value = "updateUserPersonalizedSignature")
    public int updateUserPersonalizedSignature(@RequestParam("username") String username,@RequestParam("personalizeSignature") String personalizeSignature){
        return userInfoService.updateUserPersonalizedSignature(username,personalizeSignature);
    }
}
