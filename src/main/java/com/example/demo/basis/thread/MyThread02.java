package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/4/20  23:31
 * @description: 创建线程方法1——实现Runnable
 */
public class MyThread02 implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我的名字是 ： " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread02 myThread = new MyThread02();
        Thread thread = new Thread(myThread,"thread01");

        myThread.run();
        thread.start();



    }
}
