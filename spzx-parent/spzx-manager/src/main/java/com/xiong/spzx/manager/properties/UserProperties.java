package com.xiong.spzx.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @title UserProperties
 * @description: TODO
 * @author: laughing
 * @create: 3/29/24 18:19
 */
@Data
@ConfigurationProperties(prefix = "spzx.auth")
public class UserProperties {

    private List<String> noAuthUrls;

}
