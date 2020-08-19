package com.example.demo.basis.design.singleton;

/**
 * @author : sunzhinan
 * create at:  2020/4/20  23:06
 * @description: 单例模式——懒汉式：线程不安全
 */
public class Singleton02 {
    private static Singleton02 SINGLETON02 = null;

    private Singleton02() {
    }

    public static Singleton02 getInstance(){
        if (SINGLETON02 == null){
            SINGLETON02 = new Singleton02();
        }
        return SINGLETON02;
    }
}
