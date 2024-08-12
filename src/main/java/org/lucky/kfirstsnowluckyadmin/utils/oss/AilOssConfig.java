package org.lucky.kfirstsnowluckyadmin.utils.oss;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AilOssConfig {
    @Value("${aliyun.oss.endpoint}")
    private String ENDPOINT;

    @Value("${aliyun.oss.accessKeyId}")
    private String ACCESS_KEY_ID;

    @Value("${aliyun.oss.accessKeySecret}")
    private String ACCESS_KEY_SECRET;

    @Value("${aliyun.oss.bucketName}")
    private String BUCKET_NAME;

    @Bean
    public AliOssUtils getInfo() {
        return new AliOssUtils(this);
    }
}
