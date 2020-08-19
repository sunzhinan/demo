package com.example.demo.basis.async.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: sunzhinan
 * @create: 2020-08-06 22:15
 * @description:抽象任务队列父类：定义一些共用的特性
 */
public abstract class AbstractQueue<T> implements BaseQueue<T>{
    private final static Logger LOG = LogManager.getLogger(AbstractQueue.class);

    //设置默认最大任务数——重要
    private final static int MAX_TASK_SIZE = 100;

    protected BlockingQueue<T> blockingQueue = new LinkedBlockingDeque<>(MAX_TASK_SIZE);

    @Override
    public void init(int taskNum) {
        blockingQueue = new LinkedBlockingDeque<>(taskNum);
    }

    @Override
    public T consume() {
        try {
            /**
             * 对于这里用take（）方法还是poll（）方法可以根据具体情况具体选择
             * 两者的区别就是take会阻塞，直到有任务；poll取不到直接返回null，或者根据有参方法规制时间限制
             */
            return blockingQueue.take();
        } catch (InterruptedException e) {
            LOG.debug("从队列中获取任务异常 ： e is " + e);
        }
        return null;
    }

}
