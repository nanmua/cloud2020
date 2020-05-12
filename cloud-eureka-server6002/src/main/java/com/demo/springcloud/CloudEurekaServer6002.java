package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author wxn
 * @Date 2020/5/11 0011 10:09
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer6002 {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer6002.class, args);
    }
}
