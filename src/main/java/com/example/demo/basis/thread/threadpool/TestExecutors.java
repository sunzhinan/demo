package com.example.demo.basis.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: sunzhinan
 * @create: 2020-05-23 20:54
 * @description: Executors 使用方法
 */
public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(2);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(2);
        executorService.execute(() -> System.out.println("1111"));
        executorService.shutdown();
    }
}
