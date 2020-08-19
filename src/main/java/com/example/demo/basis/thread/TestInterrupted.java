package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/10  17:10
 * @description: interrupted 方法使用
 */
public class TestInterrupted {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                System.out.println(Thread.interrupted());
                System.out.println(Thread.interrupted());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        },"自定义线程1");

        t.start();
        t.interrupt();
    }
}
