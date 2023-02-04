package com.example.demo.basis.thread;

import java.util.concurrent.*;

/**
 * @author : sun
 * create at:  2020/4/29  22:20
 * @description: 创建线程的方法4--实现Callable接口
 */
public class MyThread04 implements Callable {
    @Override
    public Integer call() throws Exception {
        System.out.println( Thread.currentThread().getName() +" 启动了");
        TimeUnit.SECONDS.sleep(10);
        return 1;
    }

    public static void main(String[] args) throws Exception {
        /**
         * 通过FutreTask包装启动
         */
        MyThread04 myThread04 = new MyThread04();
        FutureTask task = new FutureTask(myThread04);
        Thread thread = new Thread(task,"线程一");
        thread.start();
        System.out.println(task.get());

        /**
         * 通过线程池启动
         */
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> result = service.submit(myThread04);
        System.out.println(result.get());
        service.shutdown();
    }
}


