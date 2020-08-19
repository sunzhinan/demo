package com.example.demo.basis.design.singleton;

/**
 * @author : sun
 * create at:  2020/4/20  23:16
 * @description: 单例模式——懒汉式：线程安全，volatile，双重校验
 */
public class Singleton04 {
    private static volatile Singleton04 SINGLETON04 = null;

    private Singleton04() {
    }

    public static Singleton04 getInstance(){
        if(SINGLETON04 == null){
            synchronized (Singleton04.class){
                if(SINGLETON04 == null){
                    SINGLETON04 = new Singleton04();
                }
            }
        }
        return SINGLETON04;
    }
}
