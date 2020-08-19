package com.example.demo.basis.thread.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/14  19:30
 * @description: Semaphore 信号
 * 使用方法:它有两个核心方法acquire与release;首先初始化Semaphore需要指定信号值,表示同时可以执行几个线程,
 * 调用一次acquire信号值减一,调用一次release信号值加一,同时其他调用acquire的线程可以加入
 */
public class TestSemaphore {
    static Semaphore semaphore = new Semaphore(5);
    static void m(){
        System.out.println(Thread.currentThread().getName() + "执行M方法开始");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行M方法结束");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    m();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },"thread - " + i).start();
        }
    }
}
