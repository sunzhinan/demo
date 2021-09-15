package com.example.demo.zk;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: sunzhinan
 * @create: 2021-09-14 22:52
 * @description: zk连接类
 */
public class ZookeeperHandler {
    private  static Logger LOG = Logger.getLogger(ZookeeperHandler.class);
    private static ZooKeeper zk;

    private static final int sessionTimeOut = 3000;

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private NodeWatcher nodeWatcher;

    private ZookeeperInfo info;

    public void setNodeWatcher(NodeWatcher nodeWatcher) {
        this.nodeWatcher = nodeWatcher;
    }

    public static ZooKeeper getZk(String address) {
        try {
            zk = new ZooKeeper(address,sessionTimeOut, new ServerWatcher(countDownLatch));
            // 这里必须等待zk连接上才能返回zk，如果没有等待zk连接上会有问题
            countDownLatch.await();
        }  catch (IOException | InterruptedException e) {
            LOG.info("连接Zookeeper异常 ： " + JSONObject.toJSONString(e));
        }

        return zk;
    }

}
