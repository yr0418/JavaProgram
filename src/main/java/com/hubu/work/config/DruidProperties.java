package com.hubu.work.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
