package com.example.demo.basis.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-07-21 22:55
 * @description: 方法展示
 */
public class Test01 {

    //无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runAsync end ...");
        });
        future.get();
    }

    //有返回值
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("supplyAsync end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();

    }

    public static void main(String[] args) throws Exception {
        runAsync();

        supplyAsync();
    }
}
