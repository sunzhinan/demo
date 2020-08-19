package com.example.demo.basis.async.queue;

/**
 * @author: sunzhinan
 * @create: 2020-08-06 22:13
 * @description: 定义任务队列基本功能接口
 */
public interface BaseQueue<T> {
    /**
     * 初始化方法
     * @param taskNum
     */
    public void init(int taskNum);

    /**
     * 往任务队列中放入任务方法
     * @param object
     * @throws Exception
     */
    public void produce(T object) throws Exception;

    /**
     * 消费方法
     * @return
     */
    public T consume();
}
