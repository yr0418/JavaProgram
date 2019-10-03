package com.hubu.work.config;

import com.hubu.work.utils.FileConstant;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.MultipartConfigElement;

import static com.sun.deploy.util.BufferUtil.MB;
/**
 * @moduleName WebMvcConfig
 * @description web 配置类
 *
 * @author 杨睿
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
  /**
   * 配置存放用户头像的路径
   * 绝对路径
   */
  private static final String USER_IMAGES_PATH = "file:" + FileConstant.UPLOAD_PATH + FileConstant.IMG_FILE_NAME + "/";

  /**
   * 加载静态资源
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    //添加图片映射，将所有访问 /img/userImages/** 的请求映射到 存放用户头像的文件夹下
    registry.addResourceHandler("img/virtual/**").addResourceLocations(USER_IMAGES_PATH);
  }

  /**
   * 解决跨域问题
   */
  @Override
  protected void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedMethods("*")
        .allowedOrigins("*")
        .allowedHeaders("*");
  }
}
