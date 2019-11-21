package com.hubu.work.mybatis;


import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * @moduleName: CustomMapper
 * @description: 底层 mapper，tk.mybatis
 * @param <T>
 *
 * @author: 杨睿
 */
public interface CustomMapper<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper<T>, SelectByIdsMapper<T> {
}
