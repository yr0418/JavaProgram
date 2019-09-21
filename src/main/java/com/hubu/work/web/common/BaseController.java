package com.hubu.work.web.common;

import com.hubu.work.utils.PageBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
public class BaseController<T> {
  @Autowired
  BaseService<T> service;

  @ApiOperation(value = "新增实例")
  @PutMapping(value = "insert")
  public int insert(@RequestBody T t){
     return service.insert(t);
  }

  @ApiOperation(value = "根据id 删除实例")
  @DeleteMapping(value = "deleteById")
  public int deleteById(Long id){
    return service.deleteById(id);
  }

  @ApiOperation(value = "修改实例")
  @PostMapping
  public int update(@RequestBody T t){
    return service.update(t);
  }

  @ApiOperation(value = "根据 id 查询实例")
  @PostMapping(value = "selectById")
  public Object selectById(Long id){
    return service.selectById(id);
  }

  @ApiOperation(value = "分页查询实例")
  @GetMapping(value = "selectAll")
  public PageBean<T> selectAll(@RequestParam(defaultValue = "1") int pageNum,
                               @RequestParam(defaultValue = "30") int pageSize){
    return service.selectAll(pageNum,pageSize);
  }

}
