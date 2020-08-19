package com.example.demo.spring.aop.annotation;


import java.lang.annotation.*;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 11:28
 * @description: 注解类--权限
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authority {

    /**
     * 角色
     * @return
     */
    Roles[] role();
}
