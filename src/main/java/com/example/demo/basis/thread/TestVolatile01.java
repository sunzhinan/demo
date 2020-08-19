package com.example.demo.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/5/10  18:19
 * @description: volatile 使用方法
 */
public class TestVolatile01 {
    static volatile boolean flag = true;

    public static void m(){
        int i = 0;
        while (flag){
            System.out.println(i++);
        }
        System.out.println("over");
    }

    public static void main(String[] args) {
        new Thread(TestVolatile01::m).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestVolatile01.flag = false;

    }
}
