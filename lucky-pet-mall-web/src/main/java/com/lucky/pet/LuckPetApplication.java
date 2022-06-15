package com.lucky.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author qgj
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LuckPetApplication {
    public static void main(String[] args) {
        SpringApplication.run(LuckPetApplication.class, args);
    }
}
