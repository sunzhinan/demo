package com.example.demo.basis.design.proxy.dynamic;


/**
 * @author: sunzhinan
 * @create: 2020-08-08 19:43
 * @description: 测试类
 */
public class TestProxy {
    public static void main(String[] args) {
        ProxyHandler handler = new ProxyHandler();
        Role role = (Role) handler.newProxyInstance(new Celebrity());
        role.getGift();
        System.out.println("------------");
        role.getLife();

    }
}
