package com.example.demo.basis.thread.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: sunzhinan
 * @create: 2020-05-23 08:53
 * @description: LinkedTransferQueue
 */
public class TestLinkedTransferQueue {

    static LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();

    public static void main(String[] args) throws InterruptedException {
        linkedTransferQueue.offer("111");
        linkedTransferQueue.offer("222");

        linkedTransferQueue.tryTransfer("sss");
        System.out.println(linkedTransferQueue);

        linkedTransferQueue.tryTransfer("ttt",5, TimeUnit.SECONDS);
        System.out.println(linkedTransferQueue);
        System.out.println("------------------------------------");

        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 开始取出元素");
            //从这里可以看出，需要取出三次，因为main线程放入的eee是在队列的tail节点，如果不取三次，main线程依旧阻塞
            for (int i = 0; i < 3; i++) {
                System.out.println(linkedTransferQueue.poll());
            }


        },"thread01").start();

        linkedTransferQueue.transfer("eee");
    }

}
