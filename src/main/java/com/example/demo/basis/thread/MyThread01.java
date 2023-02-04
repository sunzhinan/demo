package com.example.demo.basis.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/4/20  23:27
 * @description: 创建线程方法1——继承Thread
 */
public class MyThread01 extends Thread{

    public MyThread01() {
    }

    public MyThread01(String name) {
        super(name);
    }

    @SneakyThrows
    @Override
    public void run() {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("我的名字是 ： " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * 启动
         */
        MyThread01 myThread = new MyThread01("新的测试线程1");

        myThread.run();
        myThread.start();

        /**
         * 这里可以看到Runnable的run方法和Thread的start方法的区别
         * run：还是在主线程内执行
         * start：另起一个线程执行
         */
        System.out.println("主线程执行完毕");

    }
}
