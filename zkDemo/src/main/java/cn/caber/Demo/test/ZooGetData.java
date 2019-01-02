package cn.caber.Demo.test;

import cn.caber.Demo.utils.ZooKeeperConnection;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZooGetData {

    private static ZooKeeper zk;
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeperConnection zooKeeperConnection = new ZooKeeperConnection();
        zk = zooKeeperConnection.connect("192.168.31.150");

        String path = "/a";
        final CountDownLatch connectedSignal = new CountDownLatch(1);

        Stat exists = zk.exists(path, true);
        if(exists!=null){
            byte[] b = zk.getData(path, new Watcher() {

                public void process(WatchedEvent we) {

                    if (we.getType() == Watcher.Event.EventType.None) {
                        switch(we.getState()) {
                            case Expired:
                                connectedSignal.countDown();
                                break;
                        }

                    } else {
                        String path = "/a";

                        try {
                            byte[] bn = zk.getData(path, false, null);
                            String data = new String(bn, "UTF-8");

                            System.out.println(data);

                            connectedSignal.countDown();

                        } catch(Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            }, null);

            String data = new String(b, "UTF-8");
            System.out.println(data);
            connectedSignal.await();
        }else {
            System.out.println("Node does not exists");
        }
    }
}
