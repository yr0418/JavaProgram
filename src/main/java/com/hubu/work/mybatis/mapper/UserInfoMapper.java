package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.bean.User;
import com.hubu.work.mybatis.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper extends CustomMapper<UserInfo> {

    //查询用户名与密码是否配对
    int findUser(User user);

    //查询该用户是否存在
    int findUsername(@Param("username") String username);

    //查询用户头像的路径
    String findUserImg(@Param("username") String username);

    //更新用户头像路径
    int UpdateUserImg(@Param("userImgPath")String userImgPath,@Param("username") String username);

    String findUserCity(@Param("username") String username);

    String findUserSchool(@Param("username") String username);
}