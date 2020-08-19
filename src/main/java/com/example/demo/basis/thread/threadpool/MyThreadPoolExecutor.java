package com.example.demo.basis.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/7  21:49
 * @description: 自定义线程池
 */
public class MyThreadPoolExecutor {

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4,
            0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());



}
