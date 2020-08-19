package com.example.demo.basis.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : sun
 * create at:  2020/4/21  22:02
 * @description: 创建线程的方法3——线程池
 */
public class MyThread03 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程启动了");
            }
        });

        threadPool.shutdown();
    }
}
