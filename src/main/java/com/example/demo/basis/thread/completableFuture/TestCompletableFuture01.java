package com.example.demo.basis.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-05-24 16:49
 * @description: CompletableFuture
 */
public class TestCompletableFuture01 {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{

            System.out.println(" future1 开始执行, 当前线程：" + Thread.currentThread().getName());
            System.out.println("开始获得商品");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得商品结束");
            return "aaa";
        });

        CompletableFuture<Double> future2 = future1.thenApplyAsync((name)->{

            System.out.println(" future2 开始执行 , 当前线程：" + Thread.currentThread().getName());
            System.out.println("商品是： " + name);
            System.out.println("开始获得价格");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得价格结束");
            return 2.5;
        });

        CompletableFuture<Integer> future3 = future2.thenApplyAsync((price)->{

            System.out.println(" future3 开始执行, 当前线程：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(7);
                System.out.println("3: 商品价格是： " + price);
                System.out.println("开始获得热度");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得热度结束");
            return 22500;
        });

        CompletableFuture<String> future4 = future2.thenApplyAsync((price)->{

            System.out.println(" future4 开始执行, 当前线程：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("4: 商品价格是： " + price);
                System.out.println("开始获得评论");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得评论结束");
            return "OK";
        });

        CompletableFuture<Integer> future5 = future2.thenApply((price)->{

            System.out.println(" future5 开始执行, 当前线程：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("5: 商品价格是： " + price);
                System.out.println("开始获得销量");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得销量结束");
            return 500;
        });

        CompletableFuture<Integer> future6 = future5.thenApplyAsync((num)->{

            System.out.println(" future6 开始执行, 当前线程：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("6: 商品销量是： " + num);
                System.out.println("开始获得人气");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得人气结束");
            return 1000;
        });

        future3.thenAccept((result)-> System.out.println("result3 : " + result));

        future4.thenAccept((result)-> System.out.println("result4 : " + result));

        //如果使用thenAcceptAsync你可以发现比thenAccept多了一个线程
//        future5.thenAcceptAsync((result)-> System.out.println("result5 : " + result));
        future5.thenAccept((result)-> System.out.println("result6 : " + result));

        future6.thenAccept((result)-> System.out.println("result6 : " + result));
        //thenRun不关心结果
//        future6.thenRun(() -> System.out.println("result6 :"));

        System.out.println("让主线程等待");
        TimeUnit.SECONDS.sleep(30);
        System.out.println("------OK------");
    }
}
