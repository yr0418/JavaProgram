package com.hubu.work.web.common;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseController<T> {
  @Autowired
  BaseService<T> service;

  @ApiOperation(value = "新增实例")
  @PostMapping(value = "insert")
  public int post(@RequestBody T pojo){
     return service.insert(pojo);
  }

  @ApiOperation(value = "根据id 删除实例")
  @DeleteMapping(value = "deleteById")
  public int deleteById(Long id){
    return service.deleteById(id);
  }

}
