package com.jin.zookeeper.secondexample;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * @author wu.jinqing
 * @date 2017年09月19日
 */
public class MyZooKeeperClient {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // "127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002"
        // "127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002/app/a"  the client would be rooted at "/app/a" and all paths
        //          would be relative to this root
        String connectString = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
        int sessionTimeout = 20000; // session timeout in milliseconds
        MyWatcher myWatcher = new MyWatcher();

        ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeout, myWatcher);


        Stat stat = zooKeeper.exists("/zk_test", false);

        if(null != stat)
        {
            byte[] data = zooKeeper.getData("/zk_test", false, stat);

            System.out.println(new String(data, "UTF-8"));

            System.out.println("========================");
        }

        List<String> dataList = zooKeeper.getChildren("/", false);

        dataList.forEach(System.out::println);
    }
}
