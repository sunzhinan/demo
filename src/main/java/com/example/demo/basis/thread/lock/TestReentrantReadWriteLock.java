package com.example.demo.basis.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : sun
 * create at:  2020/5/14  22:18
 * @description: 读写锁
 */
public class TestReentrantReadWriteLock {
    private static int v = 0;
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(5);
            System.out.println(" read the value");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }public static void write(Lock lock,int i){
        try {
            lock.lock();
            v = i;
            TimeUnit.SECONDS.sleep(2);
            System.out.println(" write the value");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                read(readLock);
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            int j = i;
            new Thread(()->{
                write(readLock, j);
            }).start();
        }
    }

}
