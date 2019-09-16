package com.hubu.work;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value = "com.hubu.work.mybatis.mapper")
public class WorkApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorkApplication.class, args);
  }

}
