package com.example.demo.basis.thread.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author : sun
 * create at:  2020/4/26  21:06
 * @description: LoogAdder
 */
public class TestLongAdder {

    private static LongAdder long1 = new LongAdder();

    private static AtomicLong long2 = new AtomicLong(0L);

    public static void main(String[] args) {
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    long2.incrementAndGet();
                }
            });
        }

        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        long time1 = end- start;

        System.out.println(" AtomicLong time is : " + time1);


        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    long1.increment();
                }
            });
        }

        long start2 = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end2 = System.currentTimeMillis();
        long time2 = end2- start2;

        System.out.println(" LongAdder time is : " + time2);
    }


}
