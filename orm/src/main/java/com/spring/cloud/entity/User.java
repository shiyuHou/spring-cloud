package com.spring.cloud.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author houshiyu
 * @Date 2019/11/18 下午6:14
 * @Description 用户实体类
 **/
@Data
@ToString
public class User {

    private Integer id=1;
    private String name="小明";
    private Integer age=3;
    private Integer sex=1;
}
