package com.spring.cloud.controller;

import com.spring.cloud.entity.User;
import com.spring.cloud.openfeign.CloudProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @Author houshiyu
 * @Date 2019/11/18 下午6:00
 * @Description
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CloudProductFeignClient cloudProductFeignClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 获取用户信息
     * @Param []
     * @Date 2019/11/18 下午6:21
     **/
    @GetMapping(value = "/getUserInfo")
    public String getUserInfo(){
        return new User().toString();
    }

    /**
     * 根据用户id获取用户信息
     * @Param [id]
     * @Date 2019/11/19 下午6:24
     **/
    @GetMapping(value = "/getUserById/{id}")
    public String getUserById(@PathVariable(name = "id")Long id){
        int a=1/0;
        return new User().setId(id).toString();
    }

    @GetMapping("/feignProduct")
    public String feignProduct(){
        return cloudProductFeignClient.getProductInfo();
    }

    /**
     * ribbon测试
     * @Param []
     * @Date 2019/11/22 下午2:56
     **/
    @GetMapping("/ribbon")
    public String ribbon() {

        ServiceInstance serviceInstance = loadBalancerClient.choose("cloud-product");
        //负载均衡算法默认是轮询，轮询取得服务
        URI uri = URI.create(String.format("http://%s:%s/cloud-product/test/getProductInfo", serviceInstance.getHost(), serviceInstance.getPort()));
        ResponseEntity<String> exchange = restTemplate.exchange(uri.toString(), HttpMethod.GET, null, String.class);
        return exchange.getBody();
    }
}
