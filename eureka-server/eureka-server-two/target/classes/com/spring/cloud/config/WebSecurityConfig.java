package com.spring.cloud.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author houshiyu
 * @Date 2019/11/14 下午6:43
 * @Description 关闭SpringSecurity默认开启的CSRF跨域限制校验
 *              若不关闭，回导致无法访问eureka web页面等一系列问题
 *              这里没有对此功能进行深入的研究
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}
