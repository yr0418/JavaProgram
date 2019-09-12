package com.hubu.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.hubu.work.mybatis.mapper")
public class WorkApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorkApplication.class, args);
  }

}
