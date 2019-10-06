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

    /**
     * 插入数据
     * @param record
     * @return int，返回影响的行数
     */
    int insert(Test record);
    List<Test> selectAll();


    List<Test> selectByTime(String time);
}