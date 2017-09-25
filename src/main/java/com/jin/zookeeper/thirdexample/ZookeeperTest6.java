package com.jin.zookeeper.thirdexample;

import com.jin.zookeeper.util.ZooKeeperFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author wu.jinqing
 * @date 2017年09月20日
 */
public class ZookeeperTest6 {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZooKeeperFactory.newZooKeeper();

        String path = "/ZookeeperTest6_2";

        Stat stat = zooKeeper.exists(path, (e) -> {
            System.out.println("事件触发:" + e.toString());
        });
        System.out.println("=====================");
        Thread.sleep(1000);
        String truePath = zooKeeper.create(path, "ZookeeperTest6_2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println(truePath);
    }
}
