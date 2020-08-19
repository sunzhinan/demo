package com.example.demo.basis.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-07-22 22:34
 * @description: whenComplete
 */
public class TestCompletableFuture03 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()->{
            System.out.println("future1 开始执行,当前线程是： " + Thread.currentThread().getName());
            try {
                //处理
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 执行结束");
            return 100;
        });

        //位置1--
        CompletableFuture<Integer> future2 = future1.whenComplete((a,throwable) ->{
            System.out.println(" future1 的执行结果是 ：" + a);
            System.out.println("future2 开始执行,当前线程是： " + Thread.currentThread().getName());
            try {
                //处理
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("future2 执行结束");
        });
        //位置1--

        //位置2--
        CompletableFuture<Integer> future3 = future1.whenCompleteAsync((a,throwable) ->{
            System.out.println(" future1 的执行结果是 ：" + a);
            System.out.println("future3 开始执行,当前线程是： " + Thread.currentThread().getName());
            try {
                //处理
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("future3 执行结束");
        });
        //位置2--

        CompletableFuture<Integer> future4 = future1.whenComplete((a,throwable) ->{
            System.out.println(" future1 的执行结果是 ：" + a);
            System.out.println("future4 开始执行,当前线程是： " + Thread.currentThread().getName());
            try {
                //处理
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("future4 执行结束");
        });

        CompletableFuture<Integer> future5 = future1.whenComplete((a,throwable) ->{
            System.out.println(" future1 的执行结果是 ：" + a);
            System.out.println("future5 开始执行,当前线程是： " + Thread.currentThread().getName());
            try {
                //处理
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("future5 执行结束");

        });

        future1.thenAccept((result)-> System.out.println("result1 : " + result));
        future2.thenAccept((result)-> System.out.println("result2 : " + result));
        future3.thenAccept((result)-> System.out.println("result3 : " + result));
        future4.thenAccept((result)-> System.out.println("result4 : " + result));
        future5.thenAccept((result)-> System.out.println("result5 : " + result));

        System.out.println("让主线程等待");
        TimeUnit.SECONDS.sleep(8);
        System.out.println("------OK------");

        /**
         * 结果：
         * future1 开始执行,当前线程是： ForkJoinPool.commonPool-worker-1
         * 让主线程等待
         * future1 执行结束
         * result1 : 100
         *  future1 的执行结果是 ：100
         * future5 开始执行,当前线程是： ForkJoinPool.commonPool-worker-1
         * future5 执行结束
         * result5 : 100
         *  future1 的执行结果是 ：100
         * future4 开始执行,当前线程是： ForkJoinPool.commonPool-worker-1
         * future4 执行结束
         * result4 : 100
         *  future1 的执行结果是 ：100
         * future2 开始执行,当前线程是： ForkJoinPool.commonPool-worker-1
         *  future1 的执行结果是 ：100
         * future3 开始执行,当前线程是： ForkJoinPool.commonPool-worker-2
         * future2 执行结束
         * future3 执行结束
         * result2 : 100
         * result3 : 100
         * ------OK------
         * 从上述结果可以看出，执行whenComplete任务的线程是之前执行future所使用的线程，
         * 同时后面的whenComplete会在之前的whenComplete先执行，
         * whenCompleteAsync会等所有whenComplete执行完毕再执行，这个whenCompleteAsync的位置没有关系
         * 既：位置1和位置2的代码对换，其执行结果没有变化
         * 参数：throwable 异常
         */
    }
}
