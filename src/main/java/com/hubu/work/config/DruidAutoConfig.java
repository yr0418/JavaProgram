package com.hubu.work.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @moduleName: DruidAutoConfig
 * @description: druid 配置类
 *
 * @author: 杨睿
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
public class DruidAutoConfig {

    @Autowired
    private DruidProperties properties;

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean =
            new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 白名单：
        servletRegistrationBean.addInitParameter("allow", properties.getAllow());
        // 登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", properties.getUsername());
        servletRegistrationBean.addInitParameter("loginPassword", properties.getPassword());
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        // 添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
