package com.hubu.work.web.service;

import com.hubu.work.mybatis.bean.UserSimpleInfo;
import com.hubu.work.mybatis.mapper.UserFriendsMapper;
import com.hubu.work.mybatis.pojo.UserFriends;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName: UserFriendsService
 * @description: UserFriends 对应的 Service层
 *
 * @author: 杨睿
 * @since: 2019/9/24 19:03
 */
@Service
public class UserFriendsService extends BaseService<UserFriends> {
    @Autowired
    UserFriendsMapper userFriendsMapper;

    public List<UserSimpleInfo> selectUserFriends(String username) {
        return userFriendsMapper.selectUserFriends(username);
    }

    @Override
    public int delete(UserFriends userFriends) {
        return userFriendsMapper.delete(userFriends);
    }
}
