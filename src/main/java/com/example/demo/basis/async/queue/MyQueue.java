package com.example.demo.basis.async.queue;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author: sunzhinan
 * @create: 2020-08-06 22:35
 * @description: 任务队列
 */
public class MyQueue extends AbstractQueue<QueueBaseInfo> {
    private final static Logger LOG = LogManager.getLogger(MyQueue.class);

    /**
     * 这里使用单例模式，一个程序中所产生的同一个任务类型的任务都应存放到一个任务队列
     * 因此，私有构造，使用单例模式
     */
    private final static MyQueue SINGLETON_INSTANCE = new MyQueue();

    private MyQueue(){

    }

    public static MyQueue getInstance(){
        return SINGLETON_INSTANCE;
    }

    @Override
    public void produce(QueueBaseInfo object) throws Exception {

        //获得队列中剩余位置数
        int remainingCapacity = blockingQueue.remainingCapacity();
        if(remainingCapacity == 0){
            LOG.error("任务队列满了");
            //这里需要自己自定义一个异常，为了方便，我先抛出Exception
            throw new Exception();
        }

        boolean flag = blockingQueue.offer(object);
        if(!flag){
            LOG.debug("队列满了，任务信息是：" + object.toString());
            throw new Exception();
        }
    }
}
