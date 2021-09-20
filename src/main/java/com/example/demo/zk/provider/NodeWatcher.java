package com.example.demo.zk.provider;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author: sunzhinan
 * @create: 2021-09-15 22:51
 * @description: 节点watcher
 */
public class NodeWatcher implements Watcher {

    private ZooKeeper zooKeeper;

    public NodeWatcher(ZooKeeper zooKeeper){
        this.zooKeeper = zooKeeper;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        switch (watchedEvent.getType()) {
            case None:
                break;
            case NodeCreated:
                // 如果服务创建成功
                System.out.println("节点创建成功！");
                break;
            case NodeDeleted:
                break;
            case NodeDataChanged:
                // data发生变化
                System.out.println("节点数据变化！");
                break;
            case NodeChildrenChanged:
                break;
            case DataWatchRemoved:
                break;
            case ChildWatchRemoved:
                break;
            case PersistentWatchRemoved:
                break;
        }
    }
}
