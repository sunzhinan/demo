package com.example.demo.basis.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: sunzhinan
 * @create: 2021-10-31 11:48
 * @description:
 */
public class TestCondition {
    private int n;

    private ReentrantLock lock = new ReentrantLock();
    Condition threadA = lock.newCondition();
    Condition threadB = lock.newCondition();
    public TestCondition(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            System.out.println("A");

            threadB.signalAll();
            lock.unlock();
            threadA.await();

        }

    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            threadB.await();
            System.out.println("B");

            threadA.signalAll();
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        TestCondition test = new TestCondition(10);

        new Thread(() ->{
            try {
                test.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() ->{
            try {
                test.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
