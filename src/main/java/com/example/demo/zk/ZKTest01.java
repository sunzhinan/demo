package com.example.demo.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: sunzhinan
 * @create: 2021-09-09 22:23
 * @description: zookeeper演示类1
 */
public class ZKTest01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread mainThread = Thread.currentThread();
        // 这里我连接的阿里云的服务器，需要去管理台打开端口2181
        ZooKeeper zk = new ZooKeeper("114.215.200.152:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                Event.KeeperState state = watchedEvent.getState();
                switch (state) {
                    case Unknown:
                        break;
                    case Disconnected:
                        break;
                    case NoSyncConnected:
                        break;
                    case SyncConnected:
                        // 连接成功
                        System.out.println("连接zookeeper成功！");
                        // countDownLatch.countDown();
                        System.out.println("监听回调线程name ： " + Thread.currentThread().getName());
                        LockSupport.unpark(mainThread);
                        break;
                    case AuthFailed:
                        break;
                    case ConnectedReadOnly:
                        break;
                    case SaslAuthenticated:
                        break;
                    case Expired:
                        break;
                    case Closed:
                        break;
                    default:
                        System.out.println("event OK");
                        return;
                }

            }
        });

        // countDownLatch.await();
        System.out.println("主线程name ： " + Thread.currentThread().getName());
        LockSupport.park();
        ZooKeeper.States state = zk.getState();
        switch (state) {
            case CONNECTING:
                System.out.println("连接中。。。");
                break;
            case ASSOCIATING:
                break;
            case CONNECTED:
                System.out.println("连接上。。。");
                break;
            case CONNECTEDREADONLY:
                break;
            case CLOSED:
                break;
            case AUTH_FAILED:
                break;
            case NOT_CONNECTED:
                break;
            default:
                System.out.println("zookeeper OK!");
                return;
        }

    }
}
