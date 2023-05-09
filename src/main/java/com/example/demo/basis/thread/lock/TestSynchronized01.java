package com.example.demo.basis.thread.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2023-05-09 23:08
 * @description:
 */
public class TestSynchronized01 {
    private static final Object o = new Object();
    public static void m() throws InterruptedException {
        synchronized (o){
            System.out.println("线程：" + Thread.currentThread().getName() + " 获得了m方法执行权");;
            TimeUnit.SECONDS.sleep(5);
        }
    }

    public static void n() throws InterruptedException {
        synchronized (o){
            System.out.println("线程：" + Thread.currentThread().getName() + " 获得了n方法执行权");;
            TimeUnit.SECONDS.sleep(10);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                m();
                n();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
                n();
                m();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();
    }
}
