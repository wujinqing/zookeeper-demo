## Win10 ZooKeeper单机版集群配置

此集群采用3个节点
### 环境

* 操作系统：Windows 10
* zookeeper-3.4.10

### 下载

ZooKeeper官方下载地址：[点击这里](http://zookeeper.apache.org/releases.html)

## ZooKeeper根目录
![zookeeper_root_dir](img/zookeeper_root_dir.png)

### zoo.cfg配置

> zoo1.cfg

![zoo1.cfg](img/zoo1_cfg_win.png "zoo1.cfg")

> zoo2.cfg

![zoo2.cfg](img/zoo2_cfg_win.png "zoo2.cfg")

> zoo3.cfg

![zoo3.cfg](img/zoo3_cfg_win.png "zoo2.cfg")

### zkServer配置
不能用默认的zkServer启动服务器，因为默认只会加载conf/zoo.cfg配置文件，修改

zkServer配置的目的是为了修改zoo.cfg配置文件。

设置zkServer启动时加载的配置文件：set ZOOCFG=%~dp0%..\conf\zoo3.cfg

> zkServer1.cmd

![zkServer1.cmd](img/zkServer1_win.png "zkServer1.cmd")

> zkServer2.cmd

![zkServer2.cmd](img/zkServer2_win.png "zkServer2.cmd")

> zkServer3.cmd

![zkServer3.cmd](img/zkServer3_win.png "zkServer3.cmd")

### dataDir配置
![dataDir](img/dataDir_win.png "dataDir")

### myid文件配置
> zoo1的myid文件

![myid](img/myid_zoo1_win.png "myid")

> zoo2的myid文件

![myid](img/myid_zoo2_win.png "myid")

> zoo3的myid文件

![myid](img/myid_zoo3_win.png "myid")

### 环境变量设置

> ZooKeeper环境变量设置

![ZooKeeper环境变量](img/env_prop.png "ZooKeeper环境变量")

### 启动服务器
先进入ZooKeeper根目录：D:\TMS\Tools\zookeeper-3.4.10

> zkServer1

> zkServer2

> zkServer3

![启动服务器](img/start_win.png "启动服务器")

### 使用客户端连接到服务器

> zkCli -server 127.0.0.1:2181

![客户端连接到服务器](img/zkCli_win.png "客户端连接到服务器")













