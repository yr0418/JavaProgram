package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.Skt;
import com.hubu.work.web.service.SktService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @moduleName SktController
 * @description 调用service层的方法
 * @Author 刘江
 * @since 2019-10-03 16:16
 **/
@RestController
@RequestMapping(value = "skt")
public class SktController {
    @Autowired
    SktService sktService;

    @ApiOperation(value = "插入")
    @PutMapping(value = "insert")
    public int insert(@RequestBody Skt skt){
        return sktService.insert(skt);
    }
}

