package com.spring.cloud.controller;

import com.spring.cloud.entity.User;
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
}
