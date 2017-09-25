package com.jin.zookeeper.thirdexample;

import com.jin.zookeeper.util.ZooKeeperFactory;
import com.jin.zookeeper.util.ZooKeeperUtil;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wu.jinqing
 * @date 2017年09月20日
 */
public class ZookeeperTest4 {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZooKeeperFactory.newZooKeeper();

        String path1 = "/ZookeeperTest4_1";
        String path2 = "/ZookeeperTest4_2";
        String path3 = "/ZookeeperTest4_3";
        String zk_test = "/zk_test";

        Op op1 = Op.create(path1, "ZookeeperTest4_1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Op op2 = Op.create(path2, "ZookeeperTest4_2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Op op3 = Op.create(path3, "ZookeeperTest4_3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Op op4 = Op.delete(zk_test, 0);

        List<Op> ops = new ArrayList<>();

        ops.add(op1);
        ops.add(op2);
        ops.add(op3);
        ops.add(op4);

//        List<OpResult> results = zooKeeper.multi(ops);
//
//        results.forEach( r -> {
//            System.out.println(r.getClass().getName());
//        });

        ZooKeeperUtil.recursiveShow(zooKeeper, "/");
    }
}
