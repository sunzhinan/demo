package com.example.demo.zk.provider;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * @author: sunzhinan
 * @create: 2021-09-14 22:58
 * @description: 用于提供服务的watcher
 */
public class ProviderWatcher implements Watcher {
    private CountDownLatch countDownLatch ;

    public ProviderWatcher(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        switch (watchedEvent.getState()) {
            case Unknown:
                System.out.println("----provideWatcher 1----");
                break;
            case Disconnected:
                System.out.println("----provideWatcher 2----");
                break;
            case NoSyncConnected:
                System.out.println("----provideWatcher 3----");
                break;
            case SyncConnected:
                // 当连接上了需要将锁放开
                System.out.println("----provideWatcher 4----");
                this.countDownLatch.countDown();
                break;
            case AuthFailed:
                System.out.println("----provideWatcher 5----");
                break;
            case ConnectedReadOnly:
                System.out.println("----provideWatcher 6----");
                break;
            case SaslAuthenticated:
                System.out.println("----provideWatcher 7----");
                break;
            case Expired:
                System.out.println("----provideWatcher 8----");
                break;
            case Closed:
                System.out.println("----provideWatcher 9----");
                break;
            default:
                return;
        }

    }
}
