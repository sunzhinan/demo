package com.example.demo.basis.thread;

/**
 * @author : sun
 * create at:  2020/5/10  20:55
 * @description: synchronized 可重入
 */
public class TestSynchronized03 {

    private static Object o = new Object();

    public static void m(){
        synchronized (o){
            System.out.println("1");
            n();
        };
    }

    public static void n(){
        synchronized (o){
            System.out.println("2");
        };
    }

    public static void main(String[] args) {
        TestSynchronized03.m();
    }
}
