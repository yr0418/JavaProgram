package com.hubu.work;


/**若不使用 tk.mybatis，则 MapperScan 类的引入：
 *  org.mybatis.spring.annotation.MapperScan;
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 应用模块名称: WorkApplication
 * 代码描述: Springboot 启动类
 * @author：杨睿
 */
@SpringBootApplication
@MapperScan(value = "com.hubu.work.mybatis.mapper")
public class WorkApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorkApplication.class, args);
  }

}
