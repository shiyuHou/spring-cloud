package com.spring.cloud.hystrixfallback;

import com.spring.cloud.openfeign.CloudUserFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author houshiyu
 * @Date 2019/11/19 下午4:28
 * @Description 用户服务降级处理类
 **/
@Component
public class CloudUserFeignClientFallBack implements FallbackFactory<CloudUserFeignClient>  {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloudUserFeignClientFallBack.class);

    @Override
    public CloudUserFeignClient create(Throwable throwable) {
        // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
        // 否则在引用启动时，就会打印该日志
        return new CloudUserFeignClient() {
            @Override
            public String getUserInfo() {
                LOGGER.error("fallback; reason was : ",throwable);
                return "xiao ming info  is nothing!";
            }

            @Override
            public String getUserById(Long id) {
                LOGGER.error("fallback; userId:{} , reason was : {}",id,throwable);
                return "user info  is not exist!";
            }
        };
    }
}
