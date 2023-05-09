package com.example.demo.basis.thread.lock;

import org.apache.curator.utils.ThreadUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/14  21:03
 * @description: CyclicBarrier
 * 使用方法：CyclicBarrier有两个构造，两个构造参数是：前面的参数表示线程目标数，当await的线程到达这个数的时候，执行后面Runnable
 * 里面的run方法,同时执行每个线程接下来的代码;一个参数就是:指定目标线程数,达到这个数后没有任何操作.
 * 注意事项:await的时当前线程;await会造成阻塞
 */
public class TestCyclicBarrier {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10,
            new Runnable() {
                @Override
                public void run() {
                    System.out.println("有10个人了，发车");
                }
            });

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < 101; i++) {
            int a = i;
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                    System.out.println("执行到 ： " + a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("OK****************");
        /**
         * 下面的代码时不起作用的,因为它只有主线程await了
         */
//        for (int i = 0; i < 100; i++) {
//            cyclicBarrier.await();
//        }

    }
}
