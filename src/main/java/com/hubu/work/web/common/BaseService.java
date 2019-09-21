package com.hubu.work.web.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class BaseService<T> {
  @Autowired
  protected CustomMapper<T> mapper;

  //根据id删除实例
  public int deleteById(Long id){
    return mapper.deleteByPrimaryKey(id);
  }

  //插入实例
  public int insert(T pojo){
    return mapper.insertUseGeneratedKeys(pojo);
  }

  //根据 id 修改实例
  public int update(T t){
    return mapper.updateByPrimaryKey(t);
  }

  //根据 id 查询实例
  public Object selectById(Long id){
    return mapper.selectByPrimaryKey(id);
  }

  //分页查询实例
  public PageBean<T> selectAll(int pageNum, int pageSize){
    PageHelper.startPage(pageNum,pageSize,true);
    Page<T> page = (Page<T>) mapper.selectAll();
    return new PageBean<>(page);
  }



}
