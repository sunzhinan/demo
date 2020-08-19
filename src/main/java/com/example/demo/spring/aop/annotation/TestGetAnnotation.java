package com.example.demo.spring.aop.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 22:25
 * @description: 获得注解参数
 */
public class TestGetAnnotation {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<TestMyAnnotation> aClass = (Class<TestMyAnnotation>) Class.forName("com.example.demo.spring.aop.annotation.TestMyAnnotation");

        MyAnnotation myAnnotation = aClass.getAnnotation(MyAnnotation.class);
        System.out.println("类注解上的 value : " + myAnnotation.value());
        System.out.println("类注解上的 price : " + myAnnotation.price()[0] + "   " + myAnnotation.price()[1]);
        System.out.println("----------------------------");

        //获得属性
        Field name = aClass.getDeclaredField("name");
        PropertyAnnotation propertyAnnotation = name.getAnnotation(PropertyAnnotation.class);
        System.out.println("属性上的注解 value : " + propertyAnnotation.value());

        System.out.println("----------------------------");
        Method test = aClass.getMethod("test");
        MyAnnotation annotation = test.getAnnotation(MyAnnotation.class);
        System.out.println("方法注解上的 value : " + annotation.value());
        System.out.println("方法注解上的 price : " + annotation.price()[0]+ "   " + annotation.price()[1]);

    }
}
