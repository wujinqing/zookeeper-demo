### conf/zoo.cfg 配置文件
#### tickTime 
    the basic time unit in milliseconds used by ZooKeeper. It is used to do heartbeats and the minimum session timeout will be twice the tickTime.

基本的时间单位， 单位：毫秒，心跳检测及会话超时都是基于此。
这个时间作为Zookeeper服务器之间或者服务器与客户端之间维护心跳的时间，时间单位毫秒。

#### dataDir
    the location to store the in-memory database snapshots and, unless specified otherwise, the transaction log of updates to the database.

指定存储内存数据库快照的位置

#### clientPort

    the port to listen for client connections
指定客户端连接到zookeeper的端口号

#### initLimit
zookeeper启动的时候需要等待的时间，初始化连接时, follower和leader之间的最长心跳时间.
参数配置初始化连接时, follower和leader之间的最长心跳时间. 此时该参数设置为5, 说明时间限制为5倍tickTime, 即5*2000=10000ms=10s.

选举leader的初始延时。由于服务器启动加载数据需要一定的时间（尤其是配置数据非常多），因此在选举 Leader后立即同步数据前需要一定的时间来完成初始化。可以适当放大一点。延时时间为initLimit*tickTime，也即此数值为 tickTime的次数。

#### syncLimit

用于心跳检测，如果在指定的时间(syncLimit * tickTime)毫秒内Leader没有响应Follower，说明Leader已经和Follower失联了，可能会重新选举Leader或者将Follower踢出集群。
该参数配置leader和follower之间发送消息, 请求和应答的最大时间长度. 此时该参数设置为2, 说明时间限制为2倍tickTime, 即4000ms.


此时间表示为Leader与Follower之间的最大响应时间单元，如果超时此时间（syncLimit*tickTime)，那么Leader认为Follwer也即死掉，将从服务器列表中删除。

如果是单机模式的话，那么只需要tickTime/dataDir/clientPort三个参数即可，这在单机调试环境很有效。

### 启动服务器

> bin/zkServer.sh start

默认读取conf/zoo.cfg 配置文件，也可以指定配置文件
    
> bin/zkServer.sh start conf/zoo1.cfg


### 连接到ZooKeeper服务器

> bin/zkCli.sh -server 127.0.0.1:2181

第一个端口是Leader和Follower通信的端口
第二个端口是Leader选举的端口
clientPort 是客户端连接到ZooKeeper集群的端口







