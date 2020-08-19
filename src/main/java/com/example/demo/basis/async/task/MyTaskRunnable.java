package com.example.demo.basis.async.task;

import com.example.demo.basis.async.queue.MyQueue;
import com.example.demo.basis.async.queue.QueueBaseInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author: sunzhinan
 * @create: 2020-08-06 22:08
 * @description: 具体任务类型类
 */
public class MyTaskRunnable extends AbstractBaseRunnable{
    private final static Logger LOG = LogManager.getLogger(MyTaskRunnable.class);

    public MyTaskRunnable(String threadName){
        this.setThreadName(threadName);
    }

    @Override
    public void execute() {
        LOG.info("MyTaskRunnable start !");
        //获得任务队列任务
        QueueBaseInfo info = MyQueue.getInstance().consume();

        if(info == null){
            LOG.warn("没有任务可以执行了！");
            return;
        }

        //获取任务信息
        String taskName = info.getTaskName();
        String taskId = info.getTaskId();

        //根据任务信息执行操作——此处根据业务需要处理业务逻辑
        LOG.info("taskName is" + taskName);

        LOG.info("MyTaskRunnable end !");
    }
}
