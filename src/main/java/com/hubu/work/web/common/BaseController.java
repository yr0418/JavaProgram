package com.hubu.work.web.common;

import com.hubu.work.utils.PageBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author：杨睿
 * @param <T>
 */
public class BaseController<T> {
  @Autowired
  BaseService<T> service;

  @ApiOperation(value = "新增实例，返回值：1：新增成功，0：新增失败")
  @PutMapping(value = "insert")
  public int insert(@RequestBody T t) {
    return service.insert(t);
  }

  @ApiOperation(value = "根据 id 删除实例。返回值：1：删除成功，0：删除失败")
  @DeleteMapping(value = "deleteById")
  public int deleteById(Long id) {
    return service.deleteById(id);
  }

  @ApiOperation(value = "修改实例，直接修改全部字段，前台注意数据传入。返回值：1：修改成功，0：修改失败")
  @PostMapping
  public int update(@RequestBody T t) {
    return service.update(t);
  }

  @ApiOperation(value = "根据 id 查询实例")
  @PostMapping(value = "selectById")
  public Object selectById(Long id) {
    return service.selectById(id);
  }

  @ApiOperation(value = "分页查询实例")
  @GetMapping(value = "selectAll")
  public PageBean<T> selectAll(@RequestParam(defaultValue = "1") int pageNum,
                               @RequestParam(defaultValue = "30") int pageSize) {
    return service.selectAll(pageNum, pageSize);
  }

}
