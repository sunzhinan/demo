package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/10  19:41
 * @description: 测试Volatile的原子性
 */
public class TestVolatile {
    static volatile int i = 0;

    public static void main(String[] args) {
        new Thread(()->{
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        },"线程1").start();
        new Thread(()->{
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        },"线程2").start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(i);
    }
}
