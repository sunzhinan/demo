package com.example.demo.basis.thread.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-05-22 23:19
 * @description: SynchronousQueue 使用说明
 */
public class TestSynchronousQueue {

    public static void main(String[] args) throws InterruptedException {
        //可以通过构造函数指定公平和非公平
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>(true);
        new Thread(()->{
            try {

                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " 取出元素");
                synchronousQueue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread01").start();


        System.out.println(Thread.currentThread().getName() + " 放入了元素");
        synchronousQueue.put(1);


        System.out.println(synchronousQueue);
        System.out.println(synchronousQueue.offer(2));
        System.out.println(synchronousQueue.offer(3));
        System.out.println(synchronousQueue);
    }
}
