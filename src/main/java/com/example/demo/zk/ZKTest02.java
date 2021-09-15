package com.example.demo.zk;

import org.apache.zookeeper.ZooKeeper;

/**
 * @author: sunzhinan
 * @create: 2021-09-15 20:57
 * @description: zookeeper测试类
 */
public class ZKTest02 {

    public static void main(String[] args) throws InterruptedException {

        // 第一步：获得zk连接
        ZooKeeper zk = ZookeeperHandler.getZk("114.215.200.152:2181/sunzhinan");
        ZookeeperInfo info = new ZookeeperInfo();
        ServerCallBack callBack = new ServerCallBack(zk);
        info.setNodeWatcher(new NodeWatcher(zk));
        info.setStatCallback(callBack);

        // 第二步：判断改目录下是否
        /**
         * 参数说明
         * path：节点目录
         * watch对上面这个path注册的监听
         * statCallback：回调函数，意思就是如果存在这个节点目录会调用的这个方法
         *
         */

        zk.exists("/test02", info.getNodeWatcher(), info.getStatCallback(),"/sunzhinan");

        Thread.sleep(3000);
        System.out.println("----关闭ZK连接----");
//        zk.close();
    }
}
