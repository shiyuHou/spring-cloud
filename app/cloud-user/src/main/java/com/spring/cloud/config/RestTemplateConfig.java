package com.spring.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

    //连接池的最大连接数默认为0
    private static final int MAX_TOTAL_CONNECT=0;
    //单个主机的最大连接数
    private static final int MAX_CONNECT_PER_ROUTE=200;
    //连接超时默认2s
    private static final int CONNECT_TIMEOUT=5000;
    //读取超时默认30s
    private static final int READ_TIMEOUT=50000;

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(READ_TIMEOUT);//ms
        factory.setConnectTimeout(CONNECT_TIMEOUT);//ms
        return factory;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(simpleClientHttpRequestFactory());
    }
}
