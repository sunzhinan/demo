package com.example.demo.zk.provider;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author: sunzhinan
 * @create: 2021-09-16 23:33
 * @description: 服务提供者
 *  需要注意的是，每个服务注册事件其实大体步骤是一样的
 *  1、获得zk连接
 *  2、查看需要注册的节点是否存在
 *  3、如果不存在则创建；如果存在则凭借需要注册的信息或者更新信息等操作
 *  4、其中这些过程可以对节点进行监听
 *
 */
public class ProviderService {

    private static String zookeeperAddress = "114.215.200.152:2181/sunzhinan";

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * 服务提供者
     *
     * @return
     */
    public boolean provideService(String path, String data) throws InterruptedException {
        // 获得zk连接
        ZooKeeper zk = ZookeeperHandler.getZk(zookeeperAddress);

        // 初始化连接信息
        ZookeeperInfo info = new ZookeeperInfo();
        info.setCountDownLatch(countDownLatch);
        info.setNodeWatcher(new NodeWatcher(zk));
        info.setStatCallback(new ProviderCallBack(zk));
        info.setData(data);

        // 首先判断根节点下是否有该（path）节点
        // 如果是服务注册，一开始我这里觉得我实现的功能不需要对该节点注册监听事件，因为我不关心该节点的变化，
        // 我只要将我需要的data放到该节点下即可，所以我只需要实现回调函数，但是后来我发现我年轻了
        // 原因在于我发现我不知道节点是否创建成功或者改变成功
        // ctx 是我传到回调函数中的参数，我这里传入的是根节点
        zk.exists(path, info.getNodeWatcher(), info.getStatCallback(),info);

        // 这里等待是等待节点监听完毕，获得节点监听结果
        countDownLatch.await();

        System.out.println("服务注册结果为 ： " + info.isProvideFlag());
        return info.isProvideFlag();
    }

    // 测试类
    public static void main(String[] args) throws InterruptedException {
        ProviderService service = new ProviderService();
        System.out.println(service.provideService("/provider","222"));
    }
}
