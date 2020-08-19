package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/10  16:46
 * @description: interrupt 方法使用
 */
public class TestInterrupt {

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        thread01.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread01.interrupt();

    }
}
class Thread01 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(1);
                //这里需要借助sleep来抛出InterruptedException异常
                //因为调用interrupt方法会抛出这个异常，在通过break来跳出这个循环
                System.out.println("线程执行到 ： " + i++);
            } catch (InterruptedException e) {
                System.out.println("线程中断");
                break;
            }
        }
    }
}
