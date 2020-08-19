package com.example.demo.basis.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-05-24 15:45
 * @description: CompletableFuture
 */
public class TestCompletableFuture {

    public static void main(String[] args) throws Exception {
        //通过看supplyAsync方法还有一个两个参数的，supplyAsync(Supplier<U> supplier,Executor executor)
        //然后通过源码可以看出，其实supplyAsync会将参数一任务交给它默认的ForkJoinPool线程池执行。
        //同时你也可以通过第二个参数指定一个线程池
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行任务");
            return 20;
        });

        //CompletableFuture也有get方法和FutureTask一样都会造成阻塞
        //System.out.println(future.get());

        //thenAccept没有返回值，也就是说拿到CompletableFuture执行结果后再进行处理，不需要返回什么
        System.out.println("------thenAccept start------");
        future.thenAccept((i)->{
            System.out.println("------------");
            System.out.println(i);
        });
        System.out.println("------thenAccept end------");


        //thenApply有返回值，也就是说拿到CompletableFuture执行结果后再进行处理，可以再获得结果再返回
        System.out.println("------thenApply start------");
        CompletableFuture<String> cFuture = future.thenApply((i)->{
            System.out.println("------------");
            System.out.println(i);
            return "222";
        });
        System.out.println("------thenApply end------");

        //上面的thenAccept和thenApply方法都有对应的Async异步操作，也即是thenAcceptAsync和thenApplyAsync
        //同样，他们也是将任务交给线程池执行，你也可以指定线程池


        //这里一定要加上，因为主线程不能结束，如果主线程（理解为初始化CompletableFuture的线程）结束，
        //则CompletableFuture使用的线程池会立刻关闭
        System.out.println("让主线程等待");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("cFuture : " + cFuture.get());

        System.out.println("------OK------");
    }
}
