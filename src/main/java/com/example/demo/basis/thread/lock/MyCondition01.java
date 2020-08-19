package com.example.demo.basis.thread.lock;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : sun
 * create at:  2020/5/6  21:21
 * @description: 多线程实现生产和消费者
 */
public class MyCondition01<T> {
    LinkedList<T> list = new LinkedList<>();
    final static int MAX_LENGTH = 10;
    static ReentrantLock lock = new ReentrantLock();
    Condition producter = lock.newCondition();
    Condition consumer = lock.newCondition();

    public void put(T t){
        try {
            lock.lock();
            if(list.size() == MAX_LENGTH){
                producter.await();
            }
            list.add(t);
            System.out.println(Thread.currentThread().getName() + "--生产了！");
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try {
            lock.lock();
            if(list.size() == 0){
                consumer.await();
            }
            t = list.removeFirst();
            System.out.println(Thread.currentThread().getName() + "--消费了！");
            producter.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyCondition01<Object> myCondition01 = new MyCondition01<>();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for (int j = 0; j < 4; j++) {
                    myCondition01.put(new Object());
                }
            },"生产者 " + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    myCondition01.get();
                }
            },"消费者 "+i).start();
        }
    }
}

class A<T>{
    private  static  ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    private final static int MAX_LENGTH = 10;
    LinkedList<T> list = new LinkedList<>();

    public void put(T t){
        try {
            lock.lock();
            if (list.size() == 10){
                condition1.await();
            }
            list.add(t);
            System.out.println(Thread.currentThread().getName()+" 放入");
            condition2.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try {
            lock.lock();
            if (list.size() ==0){
                condition2.await();
            }
            t = list.removeFirst();
            System.out.println(Thread.currentThread().getName()+" 拿出");
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        A<Object> myCondition01 = new A<>();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for (int j = 0; j < 4; j++) {
                    myCondition01.put(new Object());
                }
            },"生产者 " + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    myCondition01.get();
                }
            },"消费者 "+i).start();
        }
    }

}
