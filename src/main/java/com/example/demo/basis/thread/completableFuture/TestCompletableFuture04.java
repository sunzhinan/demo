package com.example.demo.basis.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-07-22 23:14
 * @description: 合并
 */
public class TestCompletableFuture04 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
            System.out.println("开始获得商品1");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得商品1结束");
            return "aaa";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            System.out.println("开始获得商品2");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得商品2结束");
            return "bbb";
        });

        CompletableFuture<String> future3 = future1.thenCombine(future2,(a,c)-> {
            System.out.println("当前线程： " + Thread.currentThread().getName());
            return a+c;
        });

        CompletableFuture<String> future4 = future1.thenCombineAsync(future2,(a,c)-> {
            System.out.println("当前线程： " + Thread.currentThread().getName());
            return a+"   "+c;
        });

       future1.thenAcceptBoth(future2,(a, c)-> {
           System.out.println("a : " + a);
           System.out.println("c : " + c);
           System.out.println("当前线程： " + Thread.currentThread().getName());
        });

        future3.thenAccept((result)->System.out.println("result3 : " + result));
        future4.thenAccept((result)->System.out.println("result4 : " + result));

        System.out.println("让主线程等待");
        TimeUnit.SECONDS.sleep(8);
        System.out.println("------OK------");
    }
}
