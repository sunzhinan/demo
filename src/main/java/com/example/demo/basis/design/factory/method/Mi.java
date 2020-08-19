package com.example.demo.basis.design.factory.method;

import com.example.demo.basis.design.factory.simple.Phone;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:21
 * @description: 小米手机
 */
public class Mi implements Phone {
    @Override
    public void playGame() {
        System.out.println("小米手机打游戏");
    }
}
