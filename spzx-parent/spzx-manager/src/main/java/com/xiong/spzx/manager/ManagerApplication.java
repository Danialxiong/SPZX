package com.xiong.spzx.manager;

import com.xiong.spzx.manager.properties.MinioProperties;
import com.xiong.spzx.manager.properties.UserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @title ManagerApplication
 * @description: TODO
 * @author: laughing
 * @create: 3/27/24 18:16
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiong.spzx"})
@EnableConfigurationProperties(value = {UserProperties.class, MinioProperties.class})
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}
