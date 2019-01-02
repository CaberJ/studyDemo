package cn.caber.Demo.test;

import cn.caber.Demo.utils.ZooKeeperConnection;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZooAddNode  {

    private  static Stat stat=new Stat();
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        ZooKeeperConnection zooKeeperConnection = new ZooKeeperConnection();
        ZooKeeper zk = zooKeeperConnection.connect("192.168.31.150");

        String path = "/a";
        //创建父节点
        zk.create(path,"node_a".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
       zk.close();
        Thread.sleep(Integer.MAX_VALUE);
    }




}
