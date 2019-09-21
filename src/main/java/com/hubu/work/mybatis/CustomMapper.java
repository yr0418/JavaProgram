package com.hubu.work.mybatis;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;
public interface CustomMapper<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper<T>, SelectByIdsMapper<T> {
}
