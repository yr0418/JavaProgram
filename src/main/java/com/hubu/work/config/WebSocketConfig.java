package com.hubu.work.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 应用模块名称：
 * 代码描述：
 *
 * @author：杨睿
 * @since 2019/9/24 10:25
 */
public class WebSocketConfig {
  @Bean
  public ServerEndpointExporter serverEndpointExporter(){
    return new ServerEndpointExporter();
  }
}
