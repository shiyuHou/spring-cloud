package com.spring.cloud.controller;

import com.spring.cloud.openfeign.CloudUserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author houshiyu
 * @Date 2019/11/18 下午6:00
 * @Description
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CloudUserFeignClient cloudUserFeignClient;
    @Value("${server.port}")
    private String message;

    @GetMapping("/feign")
    public String feign(){
        return cloudUserFeignClient.getUserInfo();
    }

    @GetMapping("/feign1/{id}")
    public String feign1(@PathVariable(name = "id") Long id){
        return cloudUserFeignClient.getUserById(id);
    }

    @GetMapping("/getProductInfo")
    public String getProductInfo(){
        String msg="i am product info!"+message;
        System.out.println(msg);
        return msg;
    }

    @GetMapping("/ribbon")
    public String ribbon(){
        String msg = "i am from cloud-product server port :"+message;
        System.out.println(msg);
        return msg;
    }
}
