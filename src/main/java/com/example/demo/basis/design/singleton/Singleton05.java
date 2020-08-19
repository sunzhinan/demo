package com.example.demo.basis.design.singleton;

/**
 * @author : sun
 * create at:  2020/4/20  23:23
 * @description: 单例模式——私有静态内部类
 */
public class Singleton05 {

    private static class SingletonHandler{
        private static final Singleton05 SINGLETON_05 = new Singleton05();
    }

    private Singleton05() {
    }

    public static Singleton05 getInstance(){
        return SingletonHandler.SINGLETON_05;
    }
}
