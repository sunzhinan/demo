package com.example.demo.spring.aop.annotation;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 22:14
 * @description: 测试自定义注解
 */
@MyAnnotation(price = {50,36})
public class TestMyAnnotation {

    @PropertyAnnotation("myName")
    public String name;

    @MyAnnotation(value = "sunzhinan",price = {23,75})
    public void test(){

    }
}
