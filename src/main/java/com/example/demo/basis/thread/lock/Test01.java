package com.example.demo.basis.thread.lock;

import java.util.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : sun
 * create at:  2020/4/26  21:45
 * @description: LockSupport
 */
public class Test01 {
    //    volatile List<Integer> array = new LinkedList<>();
    volatile List<Integer> array = Collections.synchronizedList(new LinkedList<>());

    static Thread thread1 = null;
    static Thread thread2 = null;

    public void add(int value) {
        array.add(value);
    }

    public int size() {
        return array.size();
    }

    public static synchronized void main(String[] args) {
        Test01 test01 = new Test01();

        thread2 = new Thread(() -> {
            System.out.println("长度到5了");
            LockSupport.unpark(thread1);

            LockSupport.park();
        });

        thread2.start();

        thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                test01.add(i);
                System.out.println("add " + i);
                if (test01.size() == 5) {
                    LockSupport.unpark(thread2);
                    LockSupport.park();
                }
            }
        });

        thread1.start();

    }
}
