package com.hubu.work.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

/**
 * @moduleName: TestController
 * @description: 用于Controller测试
 * @author: 杨睿
 * @since: 2019-11-21 16:33
 **/
@RestController
@RequestMapping(value = "test")
public class TestController {

    @ApiOperation(value = "获取系统时间")
    @GetMapping(value = "getDate")
    public Date getDate() {
        return new Date();
    }

}
