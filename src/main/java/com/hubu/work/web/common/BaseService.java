package com.hubu.work.web.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: 杨睿
 * @param <T>
 */
public class BaseService<T> {
  @Autowired
  protected CustomMapper<T> mapper;

  /**根据id删除实例
   * @param id：主键
   * @return int
   * 1：删除成功
   * 0：删除失败
   */
  @Transactional
  public int deleteById(Long id) {
    return mapper.deleteByPrimaryKey(id);
  }

  /**插入实例
   * @param t：实体类对象
   * @return int
   * 1：插入成功
   * 0：插入失败
   */
  @Transactional
  public int insert(T t) {
    return mapper.insertUseGeneratedKeys(t);
  }

  /**根据 id 修改实例
   * @param t：实体类对象
   * @return int
   * 1：修改成功
   * 0：修改失败
   */
  @Transactional
  public int update(T t) {
    return mapper.updateByPrimaryKey(t);
  }

  /**根据 id 查询实例
   * @param id：主键
   * @return Object
   * 返回一个具体的实体类对象
   */
  @Transactional
  public Object selectById(Long id) {
    return mapper.selectByPrimaryKey(id);
  }

  /**分页查询实例
   * @param pageNum：页数
   * @param pageSize：每一页的数量
   * @return PageBean对象
   * 返回一个PageBean对象
   */
  @Transactional
  public PageBean<T> selectAll(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize, true);
    Page<T> page = (Page<T>) mapper.selectAll();
    return new PageBean<>(page);
  }

}
