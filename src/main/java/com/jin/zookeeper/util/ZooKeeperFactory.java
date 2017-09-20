package com.jin.zookeeper.util;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author wu.jinqing
 * @date 2017年09月19日
 */
public class ZooKeeperFactory {
    /**
     * 服务器地址列表
     * 格式一: "127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002"
     * 格式二: "127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002/app/a"  the client would be rooted at "/app/a" and all paths
     * would be relative to this root
     *
     */
    public static final String CONNECT_STRING = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
    public static final int SESSION_TIMEOUT = 100 * 1000;// 会话超时时间, 单位毫秒

    public static ZooKeeper newZooKeeper() throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, new DefaultWatcher());

        return zooKeeper;
    }

    static class DefaultWatcher implements Watcher
    {
        @Override
        public void process(WatchedEvent event) {
            System.out.println("默认监听器: " + event.toString());
        }
    }
}
