package com.example.demo.basis.async.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author: sunzhinan
 * @create: 2020-08-06 21:54
 * @description: 抽象线程执行类:子类任务继承，实现具体任务类型
 */
public abstract class AbstractBaseRunnable implements Runnable{

     private static final Logger LOG = LogManager.getLogger(AbstractBaseRunnable.class);
    /**
     * 线程名称
     */
    private String threadName = "";

    /**
     * 线程运行状态标识
     */
    private volatile boolean runningFlag = true;

    /**
     * 子类具体实现方法
     */
    public abstract void execute();

    private void running(){
        try {
            execute();
        }catch (Exception e){
            LOG.debug("");
        }
    }

    public void run(){
        while (runningFlag){
            running();
        }
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public boolean isRunningFlag() {
        return runningFlag;
    }

    public void setRunningFlag(boolean runningFlag) {
        this.runningFlag = runningFlag;
    }
}
