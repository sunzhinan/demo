package com.example.demo.basis.design.factory.simple;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 21:43
 * @description: 苹果手机
 */
public class Apple implements Phone{
    @Override
    public void playGame() {
        System.out.println("用苹果手机打游戏");
    }
}
