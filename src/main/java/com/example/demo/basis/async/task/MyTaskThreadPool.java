package com.example.demo.basis.async.task;

import com.example.demo.basis.async.queue.MyQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: sunzhinan
 * @create: 2020-08-06 23:04
 * @description: 任务执行线程池
 */
public class MyTaskThreadPool implements InitializingBean, DisposableBean {
    private final static Logger LOG = LogManager.getLogger(MyTaskThreadPool.class);

    private ExecutorService threadPool;

    private int coreSize = 4;

    private int queueMaxSize = 100;

    private List<AbstractBaseRunnable> listRunnale;

    //这边可以使用构造器注入设置初始值
    public  MyTaskThreadPool(int coreSize,int queueMaxSize){
        this.coreSize = coreSize;
        this.queueMaxSize = coreSize;
    }

    @Override
    public void destroy() throws Exception {
        /**
         * 这边是在bean销毁时，释放资源
         */
        if(listRunnale != null ){
            for (AbstractBaseRunnable task:listRunnale) {
                task.setRunningFlag(false);
            }
        }

        if(threadPool != null){
            threadPool.shutdownNow();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MyQueue.getInstance().init(queueMaxSize);
        threadPool = Executors.newFixedThreadPool(coreSize);
        listRunnale = new ArrayList<>(16);
        AbstractBaseRunnable task;
        try {
            for (int i = 0; i < coreSize; i++) {
                //自定义线程名称，方便日志跟踪
                task = new MyTaskRunnable("My-Task-Thread-" + i);
                //执行任务：这里需要说明下，如果任务需要有返回值，可以使用Callable来实现
                threadPool.submit(task);
                //这边将任务加到list是结合destroy方法来处理的
                listRunnale.add(task);
            }
        }catch (Exception e){
            LOG.error(e);
        }

    }
}
