package com.example.demo.basis.thread.future;

import java.util.concurrent.*;

/**
 * @author: sunzhinan
 * @create: 2020-07-21 00:01
 * @description: FutureTask测试类
 */
public class TestFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
         * 方法一
         */
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        //这里需要注意的是，将futuretask交由Thread其本意是创建一个线程来执行子任务
        //当然你也可以直接调用futuretask的run方法，那么执行这个任务的线程就是主线程
        Thread thread = new Thread(futureTask,"线程1");
        thread.start();

        System.out.println("开始调用get方法");
        System.out.println(futureTask.get());
        System.out.println("调用get方法结束");


        /*
         * 方法二
         */
        System.out.println("----通过线程池----");
        FutureTask<Integer> task = new FutureTask<>(new MyCallable());
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(task);
        //注意这里是task来get
        System.out.println("future,我的执行结果为：" + task.get());
        executor.shutdown();

    }
}

