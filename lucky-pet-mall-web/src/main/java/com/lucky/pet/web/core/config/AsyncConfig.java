package com.lucky.pet.web.core.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhiZhou
 * @createDate: 2022/6/16 20:13
 */
@Configuration
@EnableAsync    //start Async Method
public class AsyncConfig {


    Logger logger = LoggerFactory.getLogger(AsyncConfig.class);


    public void asyncMethod() {

    }

    /**
     *  配置线程池
     * @return
     */
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(5);
        // 设置最大线程数
        executor.setMaxPoolSize(10);
        // 设置队列容量
        executor.setQueueCapacity(20);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 设置默认线程名称
        executor.setThreadNamePrefix("lucky-pet-mall-web-task-async");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
    @Resource
    private OSS ossClient;

    @Async
    public void asyncLoadUpFile(String fileNewName, InputStream inputStream) {
        logger.info("异步代码  upload File---开始---");

        PutObjectRequest putObjectRequest = new PutObjectRequest("luck-pet", fileNewName, inputStream);
        ossClient.putObject(putObjectRequest);
        logger.info("异步代码 upload  File---结束---");

    }
}
