package com.jin.zookeeper.thirdexample;

import com.jin.zookeeper.util.ZooKeeperFactory;
import com.jin.zookeeper.util.ZooKeeperUtil;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author wu.jinqing
 * @date 2017年09月20日
 */
public class ZookeeperTest5 {
    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = ZooKeeperFactory.newZooKeeper();

        String path = "/ZookeeperTest5_1";

        zooKeeper.create(path, "ZookeeperTest5_1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,
                (int rc, String pt, Object ctx, String name) -> {
                    System.out.println("rc" + rc);
                    System.out.println("name" + name);
                } , null);

        ZooKeeperUtil.recursiveShow(zooKeeper, "/");
    }
}
