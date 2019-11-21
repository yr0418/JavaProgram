package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.AuditInfo;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @moduleName AuditInfoMapper
 * @description audit_info 对应的 mapper层
 * @Author 刘旭山
 */
public interface AuditInfoMapper extends CustomMapper<AuditInfo> {

  /**
   * 查询用户接受到的申请消息的总数
   *
   * @param username 用户名
   * @return int
   */
  int getAuditInfoCountWithReceive(@Param("username") String username);
}