package com.example.demo.basis.thread.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: sunzhinan
 * @create: 2021-10-31 18:31
 * @description:
 */
public class TestSemaphore01 {
    private AtomicInteger i = new AtomicInteger(1);

    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);

    public void m()  {
        try {
            semaphore1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m" + i);
        i.incrementAndGet();

        semaphore2.release();
    }

    public void n()  {
        try {
            semaphore2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("n" + i);
        i.incrementAndGet();

        semaphore1.release();
    }

    public static void main(String[] args) {
        TestSemaphore01 testSemaphore01 = new TestSemaphore01();


        new Thread(testSemaphore01::n).start();

        new Thread(testSemaphore01::m).start();
    }
}
