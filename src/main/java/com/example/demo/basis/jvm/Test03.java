package com.example.demo.basis.jvm;

/**
 * @author: sunzhinan
 * @create: 2020-08-04 20:39
 * @description:
 */
public class Test03 {

    static {
        System.out.println(Thread.currentThread().getName() + " : 这个线程初始化了 Test03");
    }

        public static void main(String[] args) {
        new Thread(()->{
            new Test03();
            new C();
        },"Thread-01").start();

        new Thread(()->{
            new Test03();
            new C();
        },"Thread-02").start();
    }
}


class C {

    static{
        System.out.println(Thread.currentThread().getName() + " : 这个线程初始化了 C");
    }
}
