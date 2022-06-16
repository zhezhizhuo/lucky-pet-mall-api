package com.lucky.pet.web.core.upload;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.lucky.pet.common.core.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zhiZhou
 * @createDate: 2022/6/16 19:25
 */

@Component
@ConfigurationProperties(prefix = "alibaba-upload")
public class AlibabaOssUploadUtils   {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String endpoint;

    private String accessKey;

    private String accessKeySecret;

    private  String bucketName;

    public Logger getLogger() {
        return logger;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public  String getBucketName() {
        return bucketName;
    }

    public  void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @Bean
    public OSS ossClient(){
        logger.error("==> {},{},{},{}",endpoint, accessKey, accessKeySecret,bucketName);
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKey, accessKeySecret);
           if (ossClient.doesBucketExist(bucketName)) {
               logger.error("您已经创建Bucket：" + bucketName + "。");
           } else {
               logger.error("您的Bucket不存在，创建Bucket：" + bucketName + "。");
           }
        return  ossClient;
    }
}
