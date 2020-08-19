package com.example.demo.basis.design.factory.simple;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 21:43
 * @description: 华为手机
 */
public class HuaWei implements Phone{
    @Override
    public void playGame() {
        System.out.println("用华为手机打游戏");
    }
}
