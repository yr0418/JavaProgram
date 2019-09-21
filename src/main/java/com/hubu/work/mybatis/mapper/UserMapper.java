package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends CustomMapper<User> {
    //查询用户名与密码是否配对
    int findUser(User user);

    //查询该用户是否存在
    int findUsername(@Param("username") String username);

}