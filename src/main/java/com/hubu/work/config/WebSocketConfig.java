package com.hubu.work.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 应用模块名称：WebSocket配置类
 * 代码描述：当使用Springboot自带的Tomcat容器时，加入该 bean,这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
 * @author 杨睿
 * @since 2019/9/24 10:25
 */
public class WebSocketConfig {
  @Bean
  public ServerEndpointExporter serverEndpointExporter(){
    return new ServerEndpointExporter();
  }
}
