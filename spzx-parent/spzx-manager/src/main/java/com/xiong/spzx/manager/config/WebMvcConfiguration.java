package com.xiong.spzx.manager.config;

import com.xiong.spzx.manager.interceptor.LoginAuthInterceptor;
import com.xiong.spzx.manager.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @title WebMvcConfiguration
 * @description: 自定义拦截器配置类
 * @author: laughing
 * @create: 3/29/24 15:04
 */
@Component
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginAuthInterceptor loginAuthenticator;

    @Autowired
    private UserProperties userProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthenticator)
                .addPathPatterns("/**")
                .excludePathPatterns(userProperties.getNoAuthUrls());
                //.excludePathPatterns("/admin/system/index/login","/admin/system/index/generateValidateCode");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 允许所有域名访问
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许所有方法访问
                .allowCredentials(true) // 允许携带cookie
                .allowedHeaders("*") // 允许所有请求头访问
                .maxAge(3600); // 1小时内不需要再预检（发OPTIONS请求）
   }
}
