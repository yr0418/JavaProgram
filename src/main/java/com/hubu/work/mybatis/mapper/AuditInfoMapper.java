package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.pojo.AuditInfo;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @moduleName AuditInfoMapper
 * @description audit_info 对应的 mapper层
 * @Author 杨睿
 */
public interface AuditInfoMapper extends CustomMapper<AuditInfo> {
  /**
   * 查询用户接受到的申请消息的总数
   *
   * @param username 用户名
   * @return int
   */
  int getAuditInfoCountWithReceive(@Param("username") String username);

  /**
   * 查询用户接收到的申请信息中未读消息的数量
   *
   * @param username 用户名
   * @return int
   */
  int getAuditInfoCountWithReceiveAndUnread(@Param("username") String username);

  /**
   * 查询用户发送过的申请消息的总数
   *
   * @param username 用户名
   * @return int
   */
  int getAuditInfoCountWithSend(@Param("username") String username);

  /**
   * 查询用户发送出去的未审核的申请消息的总数
   *
   * @param username 用户名
   * @return int
   */
  int getAuditInfoCountWithSendAndUnread(@Param("username") String username);

  /**
   * 获取用户接受到的未读的入队申请信息
   *
   * @param username 用户名
   * @return List
   */
  List<AuditInfo> selectAuditInfoWithReceiveAndUnread(@Param("username") String username);

  /**
   * 获取用户接收到的已审核的入队申请信息
   *
   * @param username username
   * @return List
   */
  List<AuditInfo> selectAuditInfoWithReceiveAndRead(@Param("username") String username);

  /**
   * 获取用户发送的未读审核的入队申请信息
   *
   * @param username 用户名
   * @return List
   */
  List<AuditInfo> selectAuditInfoWithSendAndUnread(@Param("username") String username);

  /**
   * 获取用户发送的已被审核的入队申请信息
   *
   * @param username
   * @return
   */
  List<AuditInfo> selectAuditInfoWithSendAndRead(@Param("username") String username);
}