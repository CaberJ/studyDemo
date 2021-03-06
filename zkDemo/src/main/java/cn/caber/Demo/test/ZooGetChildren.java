package cn.caber.Demo.test;

import cn.caber.Demo.utils.ZooKeeperConnection;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class ZooGetChildren {
    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    public static Stat znode_exists(String path) throws KeeperException,InterruptedException {
        return zk.exists(path,true);
    }

    public static void main(String[] args) throws InterruptedException,KeeperException {
        String path = "/dubbo/com.dap.service.HelloService/providers";//dubbo、a、dap、zookeeper

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("192.168.31.150");
            Stat stat = znode_exists(path);

            System.out.println("stat:"+stat);

            if(stat!= null) {

                List<String> children = zk.getChildren(path, false);
                for(int i = 0; i < children.size(); i++)
                    System.out.println(children.get(i));
            } else {
                System.out.println("Node does not exists");
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
