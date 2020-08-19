package com.example.demo.basis.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-05-24 17:06
 * @description: CompletableFuture 并行
 */
public class TestCompletableFuture02 {

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

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(()->{
            System.out.println("开始获得商品3");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得商品3结束");
            return "bbb";
        });

        // 用anyOf合并
        CompletableFuture<Object> nameFuture = CompletableFuture.anyOf(future1, future2,future3);

        nameFuture.thenAccept((result) -> {
            System.out.println("------name------");
            System.out.println("name: " + result);
            System.out.println("------name------");
        });

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> dFuture1 = nameFuture.thenApplyAsync((price) -> {
            System.out.println("开始获得价格1");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得价格1结束");
            return 3.5;
        });
        CompletableFuture<Double> dFuture2 = nameFuture.thenApplyAsync((price) -> {
            System.out.println("开始获得价格2");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获得价格2结束");
            return 2.6;
        });

        //合并
        CompletableFuture<Object> priceFuture = CompletableFuture.anyOf(dFuture1, dFuture2);

        priceFuture.thenAccept((result) -> {
            System.out.println("------price------");
            System.out.println("price: " + result);
            System.out.println("------price------");
        });

        System.out.println("让主线程等待");
        TimeUnit.SECONDS.sleep(15);
        System.out.println("------OK------");
    }
}
