package com.jin.zookeeper.util;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author wu.jinqing
 * @date 2017年09月20日
 */
public class ZooKeeperUtil {
    /**
     * 递归遍历指定路径
     *
     * @param zooKeeper
     * @param path
     */
    public static void recursiveShow(ZooKeeper zooKeeper, String path)
    {
        try {
            Stat stat = zooKeeper.exists(path, true);

            if (null != stat) {
                byte[] bytes = zooKeeper.getData(path, true, stat);
                String data = new String(bytes);
                System.out.println("path: " + path + ", data: " + data);

                List<String> children = zooKeeper.getChildren(path, true);

                if(null == children || children.size() == 0)
                    return;

                children.forEach(p -> {
                    String newPath = p;

                    if("/".equals(path))
                    {
                        newPath = path + p;
                    }else
                    {
                        newPath = path + "/" + p;
                    }

                    recursiveShow(zooKeeper, newPath);
                });
            }else
            {
                System.out.println("节点不存在, path: " + path);
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
