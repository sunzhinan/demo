package com.example.demo.basis.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : sun
 * create at:  2020/5/6  22:45
 * @description: JDK自带线程池——CachedThreadPool
 */
public class TestCachedThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池");
            }
        });
    }


}
