package com.hubu.work.web.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.utils.PageBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 代码描述：底层 Service
 * @author: 杨睿
 * @param <T>
 */
public class BaseService<T> {
  @Autowired
  protected CustomMapper<T> mapper;

  /**
   * 根据id删除实例
   * @param id：主键
   * @return int
   * 1：删除成功
   * 0：删除失败
   */
  public int deleteById(Long id) {
    return mapper.deleteByPrimaryKey(id);
  }

  /**
   * 根据实例，删除实例
   * @param t
   * @return
   */
  public int delete(T t){
    return mapper.delete(t);
  }

  /**
   * 插入实例
   * @param t：实体类对象
   * @return int
   * 1：插入成功
   * 0：插入失败
   */
  public int insert(T t) {
    return mapper.insertUseGeneratedKeys(t);
  }

  /**
   * 根据 id 修改实例
   * @param t：实体类对象
   * @return int
   * 1：修改成功
   * 0：修改失败
   */
  public int update(T t) {
    return mapper.updateByPrimaryKey(t);
  }

  /**
   * 根据 id 查询实例
   * @param id：主键
   * @return Object
   * 返回一个具体的实体类对象
   */
  public Object selectById(Long id) {
    return mapper.selectByPrimaryKey(id);
  }

  /**
   * 分页查询实例
   * @return Page<T>
   */
  public Page<T> selectAll() {
    return (Page<T>) mapper.selectAll();
  }

}
