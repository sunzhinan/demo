package com.example.demo.basis.thread.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : sun
 * create at:  2020/5/10  22:09
 * @description:
 */
public class TestAtomic {
    static AtomicInteger a = new AtomicInteger(0);

    public static void m(){
        a.incrementAndGet();
//        a.getAndAdd(2);
    }

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                m();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                m();
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.get());
    }

}
