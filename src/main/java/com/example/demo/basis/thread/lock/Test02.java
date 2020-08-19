package com.example.demo.basis.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : sun
 * create at:  2020/4/26  23:06
 * @description: add和size
 */
public class Test02 {
    volatile List list = new ArrayList();

    static Thread thread1 = null;

    static Thread thread2 = null;

    public void add(Object o ){
        list.add(0);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        final Object object = new Object();
        thread1 = new Thread(() -> {

            synchronized (object){
                for (int i = 0; i < 10; i++) {
                    Object o = new Object();
                    test02.add(o);
                    System.out.println(" add " + i);
                    if(test02.size()==5){
                        object.notify();
                        try {
                            object.wait();
                            System.out.println("我暂停了");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        thread2 = new Thread(()->{
            synchronized (object){
                try {
                    object.wait();
                    System.out.println("长度到5了");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("我停了三秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                object.notify();
            }

        });

        thread2.start();
        thread1.start();
    }
}
