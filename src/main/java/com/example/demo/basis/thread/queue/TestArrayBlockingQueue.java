package com.example.demo.basis.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-05-21 22:28
 * @description: ArrayBlockingQueue 一个由数组结构组成的有界阻塞队列
 */
public class TestArrayBlockingQueue {
    //ArrayBlockingQueue有两个构造函数，还有一个构造函数第二个参数表示公平性，默认非公平
    static ArrayBlockingQueue<Integer> array = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        //首先查看add方法，不推荐使用，具体可以看下面代码，当超过队列限制的时候会抛出异常。
        //这个异常时运行时异常，所有如果你不主动catch就很难发现，个人不建议使用，比较我们
        //用到阻塞队列当然是想用它的阻塞功能，这种抛出异常的，不建议

        System.out.println("-----------add----------");
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        System.out.println(array);
//        array.add(10);

        //上面直接添加程序直接异常停止
        try{
            array.add(10);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("-----------remove----------");
        //remove方法是获得的是第一个元素，也即是下标为0的，同时数组会将这条数删除；
        //查看remove源码可知，remove实际是掉的poll方法，如果调用poll返回值为空，抛出异常；
        //如果不为空，返回这个值。
        int j = array.remove();
        System.out.println(j);
        int k = array.remove();
        System.out.println(k);
        System.out.println(array);

        //offer方法不会抛出异常，如果队列满了再进行插入，它会直接返回false。
        System.out.println("-----------offer----------");
        System.out.println(array.offer(2));
        System.out.println(array.offer(3));
        System.out.println(array.offer(4));
        System.out.println(array);

        //poll方法不会抛出异常，如果队列没有元素了，它会直接返回null。
        //同样，poll也是从头开始取出数据
        System.out.println("-----------poll----------");
        for (int i = 0; i < 10; i++) {
            System.out.println(array.poll());
        }
        System.out.println("-------------------------");
        //当元素全部清空时再进行poll将得到null
        System.out.println(array.poll());

        //这里array队列里元素已经全部没有了


        System.out.println("-----------take----------");
        //take方法，如果里面没有元素，会阻塞当前线程

        //为了演示不让当前线程阻塞住，这边我再启动个线程来往里面加入参数
        new Thread(()->{
            //这里睡10秒是为了让你感知main线程被阻塞了
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            array.offer(1);

        },"thread01").start();

        System.out.println(Thread.currentThread().getName() + " 开始take了");
        try {
            System.out.println(array.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 结束take了");
        //我可以告诉你执行结果，当thread01 offer了一个元素后，main线程就可以立马take到这个元素，这是为什么呢？
        //这里就需要去看offer源码了：首先进入offer判断元素非空，然后通过ReentrantLock加锁，如果队列满了，直接返回false；
        //如果队列不满调用enqueue（e）方法，再enqueue方法里会将这个元素放到队列里同时会调用notEmpty.signal()，
        //而notEmpty是一个Condition，表示等待获取元素的condition


        //put方法表示，如果队列满了，再往里面添加元素的时候，队列会阻塞。
        System.out.println("-----------put----------");
        for (int i = 0; i < 10; i++) {
            try {
                array.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(array);

        //为了演示不让当前线程阻塞住，这边我再启动个线程来往里面加入参数
        new Thread(()->{
            //这里睡10秒是为了让你感知main线程被阻塞了
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            array.poll();
        },"thread02").start();

        System.out.println(Thread.currentThread().getName() + " 开始put了");
        try {
            array.put(11);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 结束put了");
        System.out.println(array);
        //这里的原理直接去看dequeue这个方法，流程和上面差不多，同样有个signal唤醒的步骤

        //下面介绍offer和poll的另外一种用法

        //offer可以设置一个时间周期，在这段时间内往队列里插入元素，如果插入成功，则返回true；
        //如果插入失败，返回false，需要注意的是这段时间内当前线程阻塞
        try {
            System.out.println("开始offer，十秒内完成");
            System.out.println(array.offer(12,10,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("————————————————————");

        //poll方法同样可以设置一个时间来获取元素，原理和offer一样
        for (int i = 0; i < 10; i++) {
            array.poll();
        }
        try {
            System.out.println("开始poll，五秒内完成");
            System.out.println(array.poll(5,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
