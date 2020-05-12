package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer6001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer6001.class, args);
    }

}
