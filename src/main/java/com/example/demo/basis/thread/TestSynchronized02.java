package com.example.demo.basis.thread;

/**
 * @author : sun
 * create at:  2020/5/10  20:01
 * @description:  synchronized：执行下面代码的时候锁住这个对象
 */
public class TestSynchronized02 {
    private Object o = new Object();

    public void m(){
        synchronized (o){
            System.out.println("111");
        }
    }
}
