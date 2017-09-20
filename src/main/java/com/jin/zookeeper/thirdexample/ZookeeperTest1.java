package com.jin.zookeeper.thirdexample;

import com.jin.zookeeper.util.ZooKeeperFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author wu.jinqing
 * @date 2017年09月19日
 */
public class ZookeeperTest1 {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZooKeeperFactory.newZooKeeper();

        String path = "/zookeeperTest1";
        Stat stat = zooKeeper.exists(path, true);

        // 节点不存在
        if(null == stat)
        {
            zooKeeper.create(path, "zookeeperTest1节点数据".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        for(int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            int t = zooKeeper.getSessionTimeout();
            System.out.println("SessionTimeout-" + i+ "=" + t);
        }
    }
}
