package com.spring.cloud.openfeign;

import com.spring.cloud.config.FeignDisableHystrixConfiguration;
import com.spring.cloud.hystrixfallback.CloudUserFeignClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author houshiyu
 * @Date 2019/11/19 上午11:56
 * @Description 用户服务开放接口
 **/
// 启用Hystrix配置
@FeignClient(value = "cloud-user" , fallbackFactory = CloudUserFeignClientFallBack.class)
// 禁用Hystrix配置
//@FeignClient(value = "cloud-user" , configuration = FeignDisableHystrixConfiguration.class)
public interface CloudUserFeignClient {

    @GetMapping(value = "/cloud-user/test/getUserInfo")
    String getUserInfo();

    @GetMapping(value = "/cloud-user/test/getUserById/{id}")
    String getUserById(@PathVariable(name = "id")Long id);
}
