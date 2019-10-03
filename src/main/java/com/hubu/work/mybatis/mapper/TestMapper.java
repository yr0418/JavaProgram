package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.pojo.Test;

import java.util.List;

/**
 * @moduleName TestMapper
 * @description Test 对应的 mapper，书写相关操作 TEST 表的方法
 *
 * @author 杨睿
 */
public interface TestMapper {

    int insert(Test record);
    List<Test> selectAll();


    List<Test> selectByTime(String time);
}