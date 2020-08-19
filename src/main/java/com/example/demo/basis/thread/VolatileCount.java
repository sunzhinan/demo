package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : sun
 * create at:  2020/4/19  16:49
 * @description:
 */
public class VolatileCount {
    public volatile int i = 0;
    public int j = 0;
    public AtomicInteger ai = new AtomicInteger(0);

    void f() {
        int count = 0;
        while (count < 100000000) {
            j++;
            count++;
        }
        System.out.println("j is :" + j);
    }

    void m() {
        int count = 0;
        long startTime1 = System.currentTimeMillis();
        while (count < 100000000) {
            i++;
            count++;
        }
        long endTime1 = System.currentTimeMillis();
        long excTime1 = endTime1 - startTime1;

        System.out.println("I is :" + i);
//        System.out.println("M方法执行时间：" + excTime1 + "ms");
    }

    void n() {
        System.out.println(" start ok");
        int count = 0;
        long startTime2 = System.currentTimeMillis();
        while (count < 100000000) {
            ai.incrementAndGet();
            count++;
        }
        long endTime2 = System.currentTimeMillis();
        long excTime2 = endTime2 - startTime2;
        System.out.println("n方法执行时间：" + excTime2 + "s");
        System.out.println("AI is :" + ai);
    }

    public static void main(String[] args) {
        VolatileCount v = new VolatileCount();

        Thread t1 = new Thread() {
            @Override
            public void run() {
//                v.n();
//                v.f();
                v.m();
//                v.f();

                System.out.println("t1 执行完毕");
            }
        };
        t1.start();

        try {
            TimeUnit.MILLISECONDS.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread() {
            @Override
            public void run() {
//                v.n();
//                v.f();
                v.m();
//                v.f();
                System.out.println("t2 执行完毕");
            }
        };
        t2.start();
    }


}
