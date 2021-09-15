package com.example.demo.zk;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.Watcher;

/**
 * @author: sunzhinan
 * @create: 2021-09-15 23:07
 * @description: zookeeperx相关信息
 */
public class ZookeeperInfo {
    private Watcher sessionWatcher;

    private Watcher nodeWatcher;

    private AsyncCallback.StatCallback statCallback;

    private AsyncCallback.DataCallback dataCallback;

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
}
