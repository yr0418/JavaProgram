package com.hubu.work.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 应用模块名称:DruidProperties
 * 代码描述:druid 配置属性类
 * @author：杨睿
 */
@Data
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {
  private String url;
  private String username;
  private String password;
  private String allow;
  private String filters;
  private int maxActive;
  private int minIdle;
  private int initialSize;
  private boolean testOnBorrow;

}
