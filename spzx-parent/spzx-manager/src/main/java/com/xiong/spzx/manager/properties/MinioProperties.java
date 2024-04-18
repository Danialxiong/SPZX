package com.xiong.spzx.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @title MinioProperties
 * @description: TODO
 * @author: laughing
 * @create: 4/11/24 19:14
 */
@Data
@ConfigurationProperties(prefix="spzx.minio") //读取节点
public class MinioProperties {

    private String endpointUrl;
    private String accessKey;
    private String secreKey;
    private String bucketName;

}
