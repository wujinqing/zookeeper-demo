package com.jin.zookeeper.thirdexample;

import com.jin.zookeeper.util.ZooKeeperFactory;
import com.jin.zookeeper.util.ZooKeeperUtil;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author wu.jinqing
 * @date 2017年09月20日
 */
public class ZookeeperTest3 {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZooKeeperFactory.newZooKeeper();
//        String parent = "/ZookeeperTest3";
//        String child = "/ZookeeperTest3/sq";
//        String result = zooKeeper.create(parent, "测试3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//
//        System.out.println(result);

//        String result2 = zooKeeper.create(child, "child".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
//
//        System.out.println(result2);

        ZooKeeperUtil.recursiveShow(zooKeeper, "/");
    }
}
