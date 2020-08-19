package com.example.demo.basis.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : sun
 * create at:  2020/4/26  20:16
 * @description: ReentrantLock
 */
public class TestReentrantLock {

    static ReentrantLock lock = new ReentrantLock();

    void m() {
        try {
            lock.lock();
            System.out.println("获得了M方法的执行权——开始");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("获得了M方法的执行权——结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void n() {
        boolean locked = false;
        try {
            locked = lock.tryLock(10, TimeUnit.SECONDS);
            //只有获得锁后才能执行方法
            if(locked){
                System.out.println("获得了N方法的执行权");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TestReentrantLock testReentrantLock = new TestReentrantLock();
        new Thread(testReentrantLock::m).start();
        new Thread(testReentrantLock::n).start();
    }


}
