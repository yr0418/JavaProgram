package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.UserDetailInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface UserDetailInfoMapper extends CustomMapper<UserDetailInfo> {

    //查询用户头像的路径
    String findUserImg(@Param("username") String username);

    //更新用户头像路径
    int UpdateUserImg(@Param("userImgPath")String userImgPath,@Param("username") String username);
}