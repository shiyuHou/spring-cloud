package com.spring.cloud.openfeign;

import com.spring.cloud.hystrixfallback.CloudUserFeignClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author houshiyu
 * @Date 2019/11/19 上午11:56
 * @Description 用户服务开放接口
 **/
// 启用Hystrix配置
@FeignClient(value = "cloud-product" , fallbackFactory = CloudUserFeignClientFallBack.class)
// 禁用Hystrix配置
//@FeignClient(value = "cloud-user" , configuration = FeignDisableHystrixConfiguration.class)
public interface CloudProductFeignClient {

    @GetMapping(value = "/cloud-product/test/getProductInfo")
    String getProductInfo();

    @GetMapping("/cloud-product/test/ribbon")
    String ribbon();

}
