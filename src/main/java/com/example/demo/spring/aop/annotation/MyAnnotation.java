package com.example.demo.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 17:28
 * @description: 注解示例
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    //String是参数类型, value是参数名称
    //如果注解设置了默认值,则使用的时候可以需要设置值,如果没有默认值,则使用的时候必须要设置值
    String value() default "abc";

    int[] price();
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface PropertyAnnotation{
    String value();
}
