package com.hubu.work.web.controller;

import com.hubu.work.mybatis.bean.UserSimpleInfo;
import com.hubu.work.mybatis.pojo.UserFriends;
import com.hubu.work.utils.ImagesUtil;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.UserFriendsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @moduleName: UserFriendsController
 * @description: userFriends 对应的 控制器
 *
 * @author: 杨睿
 * @since: 2019/9/24 19:06
 */
//@RestController
//@RequestMapping(value = "userFriends")

public class UserFriendsController extends BaseController<UserFriends> {
    @Autowired
    UserFriendsService userFriendsService;

    @Autowired
    ImagesUtil imagesUtil;

    @ApiOperation(value = "获取用户的好友信息")
    @GetMapping(value = "getUserFriends")
    public List<UserSimpleInfo> selectUserFriends(String username, HttpServletRequest request) {
        List<UserSimpleInfo> list = userFriendsService.selectUserFriends(username);
        for (UserSimpleInfo user:list) {
            String path = user.getUserImgUrl();
            user.setUserImgUrl(imagesUtil.getImagesPath(request,path));
        }
        return list;
    }

    /**
     * 好友是双向好友，因此用户与其好友均有 删除好友的权限，因此在删除好友关系时，需进行两次判定：
     * 1.执行删除操作的用户的 用户名 在 user_friends 表中，存在于 username 字段，而要删除的好友的 username 在 friend 字段
     * 2.执行删除操作的用户的 用户名 在 user_friends 表中，存在于 friend 字段，而要删除的好友的 username 在 username 字段
     * @param userFriends
     * @return
     */
    @Override
    @ApiOperation(value = "删除好友")
    public int delete(@RequestBody UserFriends userFriends) {
        int count = userFriendsService.delete(userFriends);
        if (count == 1) {
            return 1;
        } else {
            String username = userFriends.getFriend();
            String friend = userFriends.getUsername();
            userFriends.setUsername(username);
            userFriends.setFriend(friend);
            return userFriendsService.delete(userFriends);
        }
    }
}
