package com.example.demo.basis.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-07-21 00:07
 * @description:
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " 开始执行！");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " 执行结束！");
        return 2;
    }
}
