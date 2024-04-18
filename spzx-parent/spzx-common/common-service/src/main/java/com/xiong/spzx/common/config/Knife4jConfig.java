package com.xiong.spzx.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title Knife4jConfig
 * @description: TODO
 * @author: laughing
 * @create: 3/27/24 17:50
 */
@Configuration
public class Knife4jConfig {

    /**
     * @Description: 定义分组
     */
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("admin-api") // 分组名称
                .pathsToMatch("/admin/**") // 匹配路径
                .build();
    }

    /**
     * @Description: 自定义接口信息
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info().title("后台管理系统API接口")
                        .version("1.0")
                        .description("后台管理系统API接口")
                        .contact(new Contact().name("laughing")));
    }
}
