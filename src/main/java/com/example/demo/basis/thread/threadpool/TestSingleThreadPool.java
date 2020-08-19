package com.example.demo.basis.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : sun
 * create at:  2020/5/6  22:14
 * @description: JDK自带线程池——SingleThreadExecutor
 *
 * SingleThreadExecutor 从源码中可以看出，该线程池只有一个核心线程，最大线程数也是一个
 *                      同时，它的任务队列是new了一个LinkedBlockingQueue，而这个
 *                      队列默认长队是Integer的最大值
 */
public class TestSingleThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池");
            }
        });
    }
}
