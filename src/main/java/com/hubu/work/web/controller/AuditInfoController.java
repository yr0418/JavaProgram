package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.AuditInfo;
import com.hubu.work.utils.DateUtil;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.AuditInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @moduleName AuditInfoController
 * @description Audit_info 对应的控制器，提供处理申请消息的API
 * @Author 刘旭山
 * @since 2019-10-10 14:40
 **/
@RestController
@RequestMapping(value = "auditInfo")
public class AuditInfoController extends BaseController<AuditInfo> {
  @Autowired
  DateUtil dateUtil;

  @Autowired
  AuditInfoService auditInfoService;


}
