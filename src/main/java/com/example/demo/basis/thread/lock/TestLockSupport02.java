package com.example.demo.basis.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : sun
 * create at:  2020/5/16  0:02
 * @description: LockSupport unpark方法先于park方法
 */
public class TestLockSupport02 {
    static Thread thread = null;

    public static void m() {
        System.out.println(Thread.currentThread().getName() + "  开始执行");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LockSupport.park();
        System.out.println(Thread.currentThread().getName() + "  执行结束");
    }

    public static void main(String[] args) {
        thread = new Thread(TestLockSupport02::m, "线程1");
        thread.start();
        LockSupport.unpark(thread);

    }
}
