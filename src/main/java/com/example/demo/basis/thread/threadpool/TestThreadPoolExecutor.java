package com.example.demo.basis.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author: sunzhinan
 * @create: 2020-05-23 12:27
 * @description: 线程池ThreadPoolExecutor使用
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args) throws  Exception{
        //这里我就先用5个参数来演示下
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,10,
                60*60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

        executor.execute(new TaskE());
        //线程池需要执行的任务量
        executor.getTaskCount();
        //线程池已完成的任务量
        executor.getCompletedTaskCount();
        //线程池里曾创建的最大线程数
        executor.getLargestPoolSize();
        //线程池的线程数
        executor.getPoolSize();
        //获得活动的线程数
        executor.getActiveCount();

        Future<Integer> future =  executor.submit(new FutureTask());
        //get会阻塞，后面会介绍CompletableFuture
        int i = future.get();
        System.out.println(i);

        //这里一定要记住，线程池记得关闭
        executor.shutdown();
    }
    
}

class TaskE implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);

            System.out.println("ssss");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FutureTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Callable 处理了");
        return 1;
    }
}
