package com.hubu.work.mybatis.bean;

import lombok.Data;

/**
 * @moduleName MessageInfo
 * @description 记录用户某一类消息的总数与未读数
 *
 * @Author 杨睿
 * @since 2019-10-08 16:24
 **/
@Data
public class MessageInfo {
  /**
   * 消息的类型
   */
  private int type;

  /**
   * 该类消息的总数
   */
  private int sum;

  /**
   * 该类消息的未读数量
   */
  private int unreadCount;
}
