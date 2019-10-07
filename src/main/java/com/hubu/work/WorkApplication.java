package com.hubu.work;


/**若不使用 tk.mybatis，则 MapperScan 类的引入：
 *  org.mybatis.spring.annotation.MapperScan;
 */

import com.hubu.work.web.socket.WebSocketController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @moduleName WorkApplication
 * @description Springboot 启动类
 * 
 * @author 杨睿
 */
@SpringBootApplication
@MapperScan(value = "com.hubu.work.mybatis.mapper")
public class WorkApplication {

  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(WorkApplication.class);
    ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
    //解决WebSocket不能注入的问题
    WebSocketController.setApplicationContext(configurableApplicationContext);

  }

}
