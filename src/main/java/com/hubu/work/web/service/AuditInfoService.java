package com.hubu.work.web.service;

import com.hubu.work.mybatis.mapper.AuditInfoMapper;
import com.hubu.work.mybatis.pojo.AuditInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName: AuditInfoService
 * @description: audit_info 对应的Service层
 *
 * @author: 刘旭山
 * @since 2019-10-09 17:04
 **/
@Service
public class AuditInfoService extends BaseService<AuditInfo> {
  @Autowired
  AuditInfoMapper auditInfoMapper;


  public int getAuditInfoCountWithReceive(String username){
    return auditInfoMapper.getAuditInfoCountWithReceive(username);
  }

  public int getAuditInfoCountWithReceiveAndUnread(String username){
    return auditInfoMapper.getAuditInfoCountWithReceiveAndUnread(username);
  }

  public int getAuditInfoCountWithSend(String username){
    return auditInfoMapper.getAuditInfoCountWithSend(username);
  }

  public int getAuditInfoCountWithSendAndUnread(String username){
    return auditInfoMapper.getAuditInfoCountWithSendAndUnread(username);
  }

  public List<AuditInfo> selectAuditInfoWithReceiveAndUnread(String username){
    return auditInfoMapper.selectAuditInfoWithReceiveAndUnread(username);
  }

  public List<AuditInfo> selectAuditInfoWithReceiveAndRead(String username){
    return auditInfoMapper.selectAuditInfoWithReceiveAndRead(username);
  }

  public List<AuditInfo> selectAuditInfoWithSendAndUnread(String username){
    return auditInfoMapper.selectAuditInfoWithSendAndUnread(username);
  }

  public List<AuditInfo> selectAuditInfoWithSendAndRead(String username){
    return auditInfoMapper.selectAuditInfoWithSendAndRead(username);
  }

  public int updateAuditInfoWithStudyInfoNotValid(Long id){
    return auditInfoMapper.updateAuditInfoWithStudyInfoNotValid(id);
  }

  public List<String> getSenderWithStudyInfoNotValid(Long id){
    return auditInfoMapper.getSenderWithStudyInfoNotValid(id);
  }

  public int updateAuditInfoWithEnjoyInfoNotValid(Long id){
    return auditInfoMapper.updateAuditInfoWithEnjoyInfoNotValid(id);
  }

  public List<String> getSenderWithEnjoyInfoNotValid(Long id){
    return auditInfoMapper.getSenderWithEnjoyInfoNotValid(id);
  }

  public int readAuditInfo(Integer result,Long id){
    return auditInfoMapper.readAuditInfo(result,id);
  }



}
