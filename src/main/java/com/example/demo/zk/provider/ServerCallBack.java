package com.example.demo.zk.provider;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.zk.ZookeeperInfo;
import lombok.SneakyThrows;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;

/**
 * @author: sunzhinan
 * @create: 2021-09-15 22:59
 * @description: 回调函数实现类
 */
public class ServerCallBack implements AsyncCallback.StatCallback , AsyncCallback.DataCallback , AsyncCallback.Create2Callback {

    private ZooKeeper zooKeeper;

    public ServerCallBack(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    /**
     * StatCallback
     *
     * @param i 节点不存在的时候为-101，节点存在的时候为0
     * @param s 节点——"/test"
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
            System.out.println("节点不存在");

            String data = "";
            if (o instanceof ZookeeperInfo){
                data = ((ZookeeperInfo) o).getData();
            }
            // 这里需要注意的是创建的节点是在之前连接是设定的根节点下创建的；不支持创建递归节点，也就是说父节点必须存在
            // 这里create有好几种参数方法，但是建议使用该方法，因为需要考虑高并发的场景，这里不需要考虑使用加锁的方式！
            // 其实为了方便，你可以通过创建持久顺序节点解决后续数据写入的高并发问题

            // 通过尝试 StringCallback 和 Create2Callback的在该处的区别就是对节点创建的校验是string还是stat，因此这里选用Create2Callback。
            zooKeeper.create(s,data.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,this,o);
            /*
            zooKeeper.create(s, "provider01".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new StringCallback() {
                @Override
                public void processResult(int i, String s, Object o, String s1) {
                    System.out.println("----StringCallback Start----");
                    System.out.println("show me i : " + i);
                    System.out.println("show me s : " + s);
                    System.out.println("show me o : " + JSONObject.toJSONString(o));
                    System.out.println("show me s1 : " + JSONObject.toJSONString(s1));
                }
            }, o);
            */
        } else{
            System.out.println("节点已存在");
            // 存入数据，存入数据之前其实是要通过获取分布式锁来操作，这里省略
            setValue(s,stat);
        }
    }

    @Override
    public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {

    }

    /**
     * Create2Callback
     *
     * @param i
     * @param s
     * @param o
     * @param s1
     * @param stat
     */
    @SneakyThrows
    @Override
    public void processResult(int i, String s, Object o, String s1, Stat stat) {
        System.out.println("----Create2Callback Start----");
        System.out.println("show me i : " + i);
        System.out.println("show me s : " + s);
        System.out.println("show me o : " + JSONObject.toJSONString(o));
        System.out.println("show me stat : " + JSONObject.toJSONString(stat));

        /*
        如果节点存在，则输出：
        show me i : -110
        show me s : /test02
        show me o : "/sunzhinan"
        show me stat : null
         */

        /*
        如果节点不存在，则输出：
        show me i : 0
        show me s : /test02
        show me o : "/sunzhinan"
        show me stat : {"aversion":0,"ctime":1631902035090,"cversion":0,"czxid":113,"dataLength":10,"ephemeralOwner":0,"mtime":1631902035090,"mzxid":113,"numChildren":0,"pzxid":113,"version":0}
         */

        // 如果stat为null说明节点已创建
        if (stat == null){
            // 将data拼接到该节点下，其实这里也有高并发的问题，需要加锁（还是通过zk的分布式锁方式或者通过radis，参考本项目代码）；为了方便这里我就不加锁了，要不然代码会很多
            setValue(s,new Stat());
        }
    }

    private void setValue(String path,Stat stat) throws InterruptedException, KeeperException {
        // 获得原先的值
        byte[] data = zooKeeper.getData(path,false,stat);
        System.out.println("原先的值为： " + new String(data));
        // 将需要设置的值通过分隔符拼接上去
        String newData = new String(data) + ";" + "ZKTest03";
        zooKeeper.setData(path,newData.getBytes(StandardCharsets.UTF_8),stat.getVersion());
    }
}
