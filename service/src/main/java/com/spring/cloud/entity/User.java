package com.spring.cloud.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author houshiyu
 * @Date 2019/11/19 下午2:35
 * @Description 用户
 **/
@Data
@ToString
public class User {

    private Long id=1L;
    private String name="xiao ming";
    private Integer age=10;
    private String sex="man";
}
