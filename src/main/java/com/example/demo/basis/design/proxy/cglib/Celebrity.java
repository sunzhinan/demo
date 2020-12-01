package com.example.demo.basis.design.proxy.cglib;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 18:02
 * @description: 具体业务实现类
 */
public class Celebrity implements Role {
    @Override
    public void getGift() {
        System.out.println("获得礼物了！");
    }

    @Override
    public void getLife() {
        System.out.println("获得life！");
    }
}