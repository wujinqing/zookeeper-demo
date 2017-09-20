package com.jin.zookeeper.thirdexample;

import com.jin.zookeeper.util.ZooKeeperFactory;
import com.jin.zookeeper.util.ZooKeeperUtil;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * @author wu.jinqing
 * @date 2017年09月20日
 */
public class ZookeeperTest2 {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZooKeeperFactory.newZooKeeper();

        String parentPath = "/ZookeeperTest2";

        Stat stat = zooKeeper.exists(parentPath, true);

        if(null == stat)
        {
            zooKeeper.create(parentPath, "zhang san".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        ZooKeeperUtil.recursiveShow(zooKeeper, "/");
    }


}
