package com.example.demo.basis.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author: sunzhinan
 * @create: 2020-05-24 10:25
 * @description: ScheduledThreadPoolExecutor
 */
public class TestScheduledThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //初始化参数5表示可以执行五个定时任务
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

        //schedule方法不是一个循环的定时任务，它只会在延迟3秒后执行一次。如果传的是Runnable就没有返回值
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行某个任务2");
            }
        },3,TimeUnit.SECONDS);

        //schedule方法不是一个循环的定时任务，它只会在延迟1秒后执行一次。如果是Callable可以获得结果
        ScheduledFuture future = executor.schedule(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("执行某个任务3");
                return 10;
            }
        },1,TimeUnit.SECONDS);
        System.out.println("future : " + future.get());


        //参数说明，第一个参数表示需要执行的任务；初始任务执行延迟时间；
        //第二个参数表示任务执行间隔；第三个参数执行时间间隔单位
        //scheduleAtFixedRate这个方法时间间隔是上次任务开始时间和下次任务开始时间的间隔，
        //也就是说，从上次任务开始计时，到了这个时间间隔如果上次任务执行完毕则立马执行，
        //如果上次任务没有执行完毕，则等待它执行完毕后立马执行。
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行某个定时任务1");
            }
        },0,10, TimeUnit.SECONDS);

        //这个方法和上面的方法参数意义一样，不一样的是这个方法的时间间隔是上次任务执行完毕到下次任务开始，
        //这段时间间隔，也就说，等上次任务执行完毕才开始计时，到了时间间隔就开始执行下次任务。
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行某个定时任务4");
            }
        },0,5,TimeUnit.SECONDS);

    }
}
