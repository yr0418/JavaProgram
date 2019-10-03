package com.hubu.work.mybatis.bean;

import lombok.Data;

/**
 * @moduleName SocketMsg
 * @description 在 WebSocket 中，封装用户发送的消息。使用json格式进行消息的发送
 *
 * @author 杨睿
 * @since 2019/9/24 11:10
 */
@Data
public class SocketMsg {
  /**
   * 消息的发送者，其值为 该用户的用户名username
   */
  private String sender;

  /**
   * 消息的接受者，username，其值为 该用户的用户名username
   */
  private String receiver;

  /**
   * 消息的类型：1：单聊，2：群发
   */
  private int type;

  /**
   * 封装消息
   */
  private String msg;
}
