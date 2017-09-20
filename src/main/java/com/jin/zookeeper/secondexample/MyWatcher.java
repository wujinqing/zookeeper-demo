package com.jin.zookeeper.secondexample;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author wu.jinqing
 * @date 2017年09月19日
 */
public class MyWatcher implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        System.out.println("event=" + event.toString());
    }
}
