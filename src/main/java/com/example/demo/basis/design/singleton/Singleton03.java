package com.example.demo.basis.design.singleton;

/**
 * @author : sun
 * create at:  2020/4/20  23:10
 * @description: 单例模式——懒汉式：线程安全，synchronized
 */
public class Singleton03 {
    private static Singleton03 SINGLETON03 = null;
    private Singleton03() {
    }

    public static synchronized Singleton03 getInstance() {
        if (SINGLETON03 == null)
        {
            SINGLETON03 = new Singleton03();
        }
        return SINGLETON03;
    }
}
