package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/4/19  16:03
 * @description:
 */
public class HelloVolatile {
    volatile boolean running = true;

    void m() {
        System.out.println(" is start ok");
        while (running) {
        }
        System.out.println(" is end ok");
    }

    public static void main(String[] args) {
        HelloVolatile hello = new HelloVolatile();
        new Thread(hello::m,"ss").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hello.running = false;
    }
}
