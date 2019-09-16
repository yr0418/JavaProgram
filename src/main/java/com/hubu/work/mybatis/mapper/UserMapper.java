package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper extends CustomMapper<User> {
    List<User> selectAll();

    //查询该用户是否存在
    int findUser(User user);

    //修改用户头像的path
    int updateImg(@Param("avatarUrl") String imgPath,@Param("username") String username);

    //查询用户头像的相对路径
    String findImgPath(@Param("username") String username);
}