package com.example.demo.basis.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 21:43
 * @description: 测试类
 */
public class TestProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Celebrity.class);
        enhancer.setCallback(new MyMethodInterceptor());

        Celebrity celebrity = (Celebrity) enhancer.create();
        celebrity.getGift();
        System.out.println("-------------");
        celebrity.getLife();
    }
}
