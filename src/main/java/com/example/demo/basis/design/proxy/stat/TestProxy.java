package com.example.demo.basis.design.proxy.stat;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 18:05
 * @description: 测试类
 */
public class TestProxy {
    public static void main(String[] args) {
        RoleProxy roleProxy = new RoleProxy(new Celebrity());
        RoleMethodProxy roleMethodProxy = new RoleMethodProxy(roleProxy);
        roleMethodProxy.getGift();
    }
}
