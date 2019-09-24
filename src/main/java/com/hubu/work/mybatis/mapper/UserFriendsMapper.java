package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.bean.UserFriend;
import com.hubu.work.mybatis.pojo.UserFriends;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 代码模块：UserFriendSMapper 代码描述： UserFriends 对应的 mapper层
 * 
 * @author 杨睿
 */
public interface UserFriendsMapper extends CustomMapper<UserFriends> {
    /**
     * 查询该用户的简要好友信息：用户名，昵称
     * 由于好友关系是双向好友关系，因此查询时，
     * 1.不仅要查 user_friend.username = username
     * 2.还有查询 user_friend.friend = username
     *
     * @param username：要查询的用户的用户名
     * @return List<UserFriends>
     */
    List<UserFriend> selectUserFriends(@Param("username") String username);

    /**
     * 重写 delete 方法，根据实例删除实例，不考虑主键id
     * @param userFriends 要删除的实例
     * @return 影响的行数
     */
    @Override
    int delete(UserFriends userFriends);

}