package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/10  11:19
 * @description: 测试join方法
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread01");
        });
        Thread thread02 = new Thread(()->{
            try {
                thread01.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread02");
        });

        thread01.start();
        thread02.start();
    }
}

