package com.example.demo.zk.provider;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * @author: sunzhinan
 * @create: 2021-09-15 23:07
 * @description: zookeeperx相关信息
 */
public class ZookeeperInfo {
    private String data;

    private Watcher sessionWatcher;

    private Watcher nodeWatcher;

    private CountDownLatch countDownLatch;

    private AsyncCallback.StatCallback statCallback;

    private AsyncCallback.DataCallback dataCallback;

    /**
     * 服务注册结果
     */
    private boolean provideFlag;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isProvideFlag() {
        return provideFlag;
    }

    public void setProvideFlag(boolean provideFlag) {
        this.provideFlag = provideFlag;
    }

    public Watcher getSessionWatcher() {
        return sessionWatcher;
    }

    public void setSessionWatcher(Watcher sessionWatcher) {
        this.sessionWatcher = sessionWatcher;
    }

    public Watcher getNodeWatcher() {
        return nodeWatcher;
    }

    public void setNodeWatcher(Watcher nodeWatcher) {
        this.nodeWatcher = nodeWatcher;
    }

    public AsyncCallback.StatCallback getStatCallback() {
        return statCallback;
    }

    public void setStatCallback(AsyncCallback.StatCallback statCallback) {
        this.statCallback = statCallback;
    }

    public AsyncCallback.DataCallback getDataCallback() {
        return dataCallback;
    }

    public void setDataCallback(AsyncCallback.DataCallback dataCallback) {
        this.dataCallback = dataCallback;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
