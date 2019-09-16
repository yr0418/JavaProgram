package com.hubu.work.web.common;

import com.hubu.work.mybatis.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService<T> {
  @Autowired
  CustomMapper mapper;

  public int deleteById(Long id){
    return mapper.deleteByPrimaryKey(id);
  }

  public int insert(T pojo){
    return mapper.insertUseGeneratedKeys(pojo);
  }

}
