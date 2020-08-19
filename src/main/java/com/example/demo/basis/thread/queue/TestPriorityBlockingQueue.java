package com.example.demo.basis.thread.queue;

import lombok.Data;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author: sunzhinan
 * @create: 2020-05-22 22:07
 * @description: PriorityBlockingQueue 使用方法
 */
public class TestPriorityBlockingQueue {

    public static void main(String[] args) {
        PriorityBlockingQueue<Car> priorityQueue = new PriorityBlockingQueue<>();
        priorityQueue.offer(new Car(22,"bbb"));
        priorityQueue.offer(new Car(23,"aaa"));
        System.out.println(priorityQueue);
        priorityQueue.offer(new Car(20,"ccc"));
        System.out.println(priorityQueue);
        priorityQueue.offer(new Car(21,"ddd"));
        System.out.println(priorityQueue);
        priorityQueue.offer(new Car(11,"eee"));
        System.out.println(priorityQueue);
        priorityQueue.offer(new Car(15,"fff"));
        System.out.println(priorityQueue);

        /**
         * [Car(id=22, name=bbb), Car(id=23, name=aaa)]
         * [Car(id=20, name=ccc), Car(id=23, name=aaa), Car(id=22, name=bbb)]
         * [Car(id=20, name=ccc), Car(id=21, name=ddd), Car(id=22, name=bbb), Car(id=23, name=aaa)]
         * [Car(id=11, name=eee), Car(id=20, name=ccc), Car(id=22, name=bbb), Car(id=23, name=aaa), Car(id=21, name=ddd)]
         * [Car(id=11, name=eee), Car(id=20, name=ccc), Car(id=15, name=fff), Car(id=23, name=aaa), Car(id=21, name=ddd), Car(id=22, name=bbb)]
         */

        //由上面的执行结果可以看出，只要往里面插入一个元素，都会进行排序，但是只会把按照排序规则排在第一位的元素排在第一个；
        //也就是说只能保证第一个是最优先的，后面的元素是按照一系列复杂算法排序。

    }

}

@Data
class Car implements Comparable<Car>{

    private int id;

    private String name;

    public Car(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.id, car.getId());
    }

}

