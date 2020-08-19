package com.example.demo.basis.thread.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : sun
 * create at:  2020/4/26  19:54
 * @description: 读写锁
 */
public class TestReadWriteLock {
    static int V = 0;
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {

        try {
            lock.lock();

            Thread.sleep(10);
            System.out.println(" read the value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void write(Lock lock, int value) {
        try {
            lock.lock();

            Thread.sleep(1000);

            V = value;
            System.out.println(" write the value, V is " + V);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Runnable runnable1 = () -> read(readLock);
        Runnable runnable2 = () -> write(writeLock, new Random().nextInt());

        for (int i = 0; i < 10; i++) {
            new Thread(runnable2).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(runnable1).start();
        }

    }

}
