package com.hubu.work.config;

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

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    //解决跨域问题
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }

    //文件上传
    @Value("${cbs.images-path}")
    private  String userImagesPath;
//    @Bean
//    public MultipartConfigElement multipartConfigElement(){
//        MultipartConfigFactory factory=new MultipartConfigFactory();
//        factory.setMaxFileSize(DataSize.ofMegabytes(1024L));
//        factory.setMaxRequestSize(DataSize.ofMegabytes(1024L));
//        return factory.createMultipartConfig();
//    }

//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if(userImagesPath.equals("") || userImagesPath.equals("${cbs.imagesPath}")){
//            String imagesPath = WebMvcConfig.class.getClassLoader().getResource("").getPath();
//            System.out.print("1.上传配置类imagesPath=="+imagesPath+"\n");
//            if(imagesPath.indexOf(".jar")>0){
//                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
//            }else if(imagesPath.indexOf("classes")>0){
//                imagesPath = "file:"+imagesPath.substring(0, imagesPath.indexOf("classes"));
//            }
//            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/"))+"/images/";
//            userImagesPath = imagesPath;
//        }
//        System.out.println("imagesPath============="+userImagesPath);
//        registry.addResourceHandler("/images/**").addResourceLocations(userImagesPath);
//        System.out.println("2.上传配置类mImagesPath=="+userImagesPath);
//        super.addResourceHandlers(registry);
//    }

    public String getUserImagesPath() {
        return userImagesPath;
    }

    public void setUserImagesPath(String userImagesPath) {
        this.userImagesPath = userImagesPath;
    }
}
