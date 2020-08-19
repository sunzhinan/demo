package com.example.demo.basis.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/14  19:32
 * @description: CountDownLatch
 * 使用方法：首先初始化是指定大小，可以理解为指定座位数，一个线程执行完业务步骤后调用countDown方法，当前线程就类似于做到座位上了，
 * 在主线程里调用await方法，意思就是等座位上的所有线程执行完毕后，执行下面的代码，这里会造成阻塞。
 * 在使用的时候需要注意：在指定CountDownLatch初始参数的时候一定要预判好有几个位置，因为只有位置坐满了，并且每个位置的线程都执行
 * 结束，才会执行await后面的代码。
 */
public class TestCountDownLatch {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                countDownLatch.countDown();
                System.out.println("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(8);
                countDownLatch.countDown();
                System.out.println("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                countDownLatch.countDown();
                System.out.println("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程3").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(20);
                countDownLatch.countDown();
                System.out.println("4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程4").start();

        try {
            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);

    }
}
