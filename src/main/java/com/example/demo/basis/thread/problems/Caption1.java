package com.example.demo.basis.thread.problems;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: sunzhinan
 * @create: 2021-10-30 13:10
 * @description: leetcode-1114
 */
public class Caption1 {
    private AtomicBoolean first = new AtomicBoolean(true);
    private AtomicBoolean second = new AtomicBoolean(true);


    public Caption1() {

    }
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.compareAndSet(true,false);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(first.get()){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.compareAndSet(true,false);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(second.get()){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

