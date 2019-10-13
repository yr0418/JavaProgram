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
 * @Author 杨睿
 * @since 2019-10-10 14:40
 **/
@RestController
@RequestMapping(value = "auditInfo")
public class AuditInfoController extends BaseController<AuditInfo> {
  @Autowired
  DateUtil dateUtil;

  @Autowired
  AuditInfoService auditInfoService;

  @Override
  public int insert(@RequestBody AuditInfo auditInfo){
    auditInfo.setDate(dateUtil.setTime());
    auditInfo.setAuditStatus(0);
    auditInfo.setAuditResult(0);
    return auditInfoService.insert(auditInfo);
  }

  @ApiOperation(value = "获取用户接收到的用户申请信息")
  @GetMapping(value = "getAuditInfoWithReceived")
  public List<AuditInfo> getAuditInfoWithReceived(String username){
    List<AuditInfo> list1 = auditInfoService.selectAuditInfoWithReceiveAndUnread(username);
    List<AuditInfo> list2 = auditInfoService.selectAuditInfoWithReceiveAndRead(username);
    List<AuditInfo> result = new ArrayList<>();
    result.addAll(list1);
    result.addAll(list2);
    return result;
  }

  @ApiOperation(value = "获取用户发送的入队申请信息")
  @GetMapping(value = "getAuditInfoWithSend")
  public List<AuditInfo> getAuditInfoWithSend(String username){
    List<AuditInfo> list1 = auditInfoService.selectAuditInfoWithSendAndRead(username);
    List<AuditInfo> list2 = auditInfoService.selectAuditInfoWithSendAndUnread(username);
    List<AuditInfo> result = new ArrayList<>();
    result.addAll(list1);
    result.addAll(list2);
    return result;
  }
}
