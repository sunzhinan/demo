package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/14  19:51
 * @description: join方法演示
 */
public class TestJoin01 {
    public static void main(String[] args) {
        Thread thread01 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread01");

        Thread thread02 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread02");

        Thread thread03 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread03");

        long startTime = System.currentTimeMillis();
        thread01.start();
        thread02.start();
        thread03.start();

        try {
            thread01.join();
            thread02.join();
            thread03.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
