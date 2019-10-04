package com.hubu.work.mybatis.pojo;

import javax.persistence.Id;

/**
 * @moduleName UserFriends
 * @description 对应数据库 user_friends 表，保存用户好友信息
 *
 * @Author 杨睿
 */
public class UserFriends {
    @Id
    private Long id;

    private String username;

    private String friend;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend == null ? null : friend.trim();
    }
}