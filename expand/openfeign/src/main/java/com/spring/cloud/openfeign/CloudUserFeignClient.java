package com.spring.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author houshiyu
 * @Date 2019/11/19 上午11:56
 * @Description 用户服务开放接口
 **/
@FeignClient(value = "cloud-user")
public interface CloudUserFeignClient {

    @GetMapping(value = "/cloud-user/test/getUserInfo")
    String getUserInfo();
}
