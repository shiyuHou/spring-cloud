package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker       //开启服务容错
@EnableFeignClients         //开启远程调用
@EnableDiscoveryClient      //开启服务注册
@SpringBootApplication
public class CloudProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProductApplication.class, args);
    }

}
