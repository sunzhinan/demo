package com.example.demo.zk;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;

/**
 * @author: sunzhinan
 * @create: 2021-09-15 22:59
 * @description: 回调函数实现类
 */
public class ServerCallBack implements AsyncCallback.StatCallback , AsyncCallback.DataCallback {

    private ZooKeeper zooKeeper;

    public ServerCallBack(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    /**
     *
     * @param i -101
     * @param s 节点
     * @param o 调用改方法时传入的上下文（ctx）
     * @param stat 节点状态，如果不存在为null
     */
    @SneakyThrows
    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        System.out.println("----ServerCallBack Start----");
        System.out.println("show me i : " + i);
        System.out.println("show me s : " + s);
        System.out.println("show me o : " + JSONObject.toJSONString(o));
        System.out.println("show me stat : " + JSONObject.toJSONString(stat));

        // 如果stat不为null表示节点已创建，反之表示节点不存在
        /*
        节点样例：
        show me stat : {"aversion":0,"ctime":1631719711746,"cversion":0,"czxid":30,"dataLength":6,"ephemeralOwner":0,"mtime":1631719711746,"mzxid":30,"numChildren":0,"pzxid":30,"version":0}
         */
        // 因为我们是演示的服务注册，那么stat不存在的时候，我们需要创建它
        if(stat == null){
            // 这里需要注意的是创建的节点是在之前连接是设定的根节点下创建的；不支持创建递归节点，也就是说父节点必须存在
            zooKeeper.create(s, "ZKTest02".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    @Override
    public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {

    }
}
