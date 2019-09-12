package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> selectAll();
}