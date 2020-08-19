package com.example.demo.basis.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : sun
 * create at:  2020/5/16  23:13
 * @description: LockSupport 锁是否可重入
 */
public class TestLockSupport03 {
    static Thread thread = null;

    public static void m(){
        LockSupport.unpark(thread);
        LockSupport.park();
        System.out.println("m 方法进入");
        try {
            TimeUnit.SECONDS.sleep(3);
            n();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m 方法退出");

    }

    public static void n(){

        LockSupport.park();
        System.out.println("n 方法进入");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("n 方法退出");
        LockSupport.unpark(thread);
    }

    public static void main(String[] args) {
        thread = new Thread(TestLockSupport03::m);
        thread.start();
    }
}
