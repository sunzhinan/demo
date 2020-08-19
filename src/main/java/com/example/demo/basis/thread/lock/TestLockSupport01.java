package com.example.demo.basis.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : sun
 * create at:  2020/5/15  23:31
 * @description: LockSupport 用法
 */
public class TestLockSupport01 {
    static Thread thread01 = null;
    static Thread thread02 = null;

    public static void m(){
        try {
            System.out.println(Thread.currentThread().getName() + "进入了");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + "结束了");
            LockSupport.unpark(thread02);
            LockSupport.park();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void n(){
        try {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "进入了");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "结束了");
            LockSupport.unpark(thread01);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        thread01 = new Thread(TestLockSupport01::m,"线程1");
        thread02 = new Thread(TestLockSupport01::n,"线程2");

        thread01.start();
        thread02.start();
    }
}
