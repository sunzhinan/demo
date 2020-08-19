package com.example.demo.basis.design.singleton;

/**
 * @author : sunzhinan
 * create at:  2020/4/20  23:05
 * @description: 单例模式——饿汉式
 */
public class Singleton01 {
    private static final Singleton01 SINGLETON_01 = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getInstance(){
        return SINGLETON_01;
    }
}
