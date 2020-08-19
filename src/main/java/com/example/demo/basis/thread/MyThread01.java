package com.example.demo.basis.thread;

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

    @Override
    public void run() {
        System.out.println("新的线程创建成功了，我的名字是 ： " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        /**
         * 第一中启动方式
         */
        MyThread01 myThread01 = new MyThread01();
        myThread01.start();

        MyThread01 myThread = new MyThread01("自命名");
        myThread.start();

        /**
         * 第二种启动方式
         */
        Thread thread = new Thread(myThread01,"thread01");
        thread.start();
    }
}
