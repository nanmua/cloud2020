package com.demo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wxn
 * @Date 2020/4/29 0029 15:03
 */
@SpringBootApplication
@MapperScan(basePackages="com.demo.springcloud.dao")//扫描Mapper文件
@EnableEurekaClient
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
