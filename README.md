## ZooKeeper学习笔记


##### [Zookeeper配置详解](doc/Zookeeper配置详解.md)

##### [ZooKeeper单机版集群配置](doc/ZooKeeper单机版集群配置.md)

### 监听器(Watcher)的生命周期
一旦客户端被关闭，session将会失效，此客户端所创建的所有临时节点
(ephemeral nodes)将会被删除，关联在这些节点及父节点上的所有监听器将会被触发。

原文：
>

翻译：
>


### What is ZooKeeper
原文：
> ZooKeeper is a centralized service for maintaining configuration
information, naming, providing distributed synchronization,
and providing group services. All of these kinds of services are
used in some form or another by distributed applications.
Each time they are implemented there is a lot of work that goes into
fixing the bugs and race conditions that are inevitable.
Because of the difficulty of implementing these kinds of services,
applications initially usually skimp on them ,which make them
brittle in the presence of change and difficult to manage. Even when
done correctly, different implementations of these services lead to
management complexity when the applications are deployed.

翻译：
> ZooKeeper是一个集中式的服务为了维护配置信息、命名、提供分布式同步(如：分布式事务)、
提供一组服务(如: 作为dubbo的服务注册中心)，所有这些类似的服务都以某种形式存在于
分布式系统中。

原文：
> ZooKeeper data is kept in-memory, which means ZooKeeper can achieve
  high throughput and low latency numbers.

翻译：
> ZooKeeper的数据是保持在内存里的，这就意味着ZooKeeper可以获得高吞吐量及低延迟。


原文：
> The ZooKeeper implementation puts a premium on high performance,
highly available, strictly ordered access. The performance aspects of
ZooKeeper means it can be used in large, distributed systems.
The reliability aspects keep it from being a single point of failure.
The strict ordering means that sophisticated synchronization primitives
can be implemented at the client.

翻译：
> ZooKeeper在高性能、高可用、严格顺序访问方面具有非常好的表现。 高性能意味着ZooKeeper
可用于很大的分布式系统中、高可用意味着在出现单点故障时不会影响系统的可用性、严格顺序
意味着复杂的同步原语可以在客户端实现(分布式事务)。

原文：
> The servers that make up the ZooKeeper service must all know about
each other. They maintain an in-memory image of state, along with
a transaction logs and snapshots in a persistent store. As long as
a majority of the servers are available, the ZooKeeper service will be
available.

翻译：
> 组成ZooKeeper集群的各个服务必须知道各自的存在，他们各自在内存里维护了一个状态图、
连同事务日志及持久化存储的快照也在内存里。只要集群中的大多数服务可用，ZooKeeper服务
就可用。


原文：
> Clients connect to a single ZooKeeper server. The client maintains
a TCP connection through which it sends requests, gets responses,
gets watch events, and sends heart beats. If the TCP connection to
the server breaks, the client will connect to a different server.

翻译：
> 客户端使用TCP协议连接到ZooKeeper集群中的单个服务，进行sends requests、
gets responses、gets watch events及sends heart beats。如果连接断开，
客户端将重新连接到ZooKeeper集群中的另一个服务中。


原文：
> ZooKeeper stamps each update with a number that reflects the order of
all ZooKeeper transactions. Subsequent operations can use the order to
implement higher-level abstractions, such as synchronization primitives.

翻译：
> ZooKeeper使用一个数字来标记每一次的更新，可以通过这个来实现同步原语。


原文：
> It is especially fast in "read-dominant" workloads. ZooKeeper
applications run on thousands of machines, and it performs best where
reads are more common than writes, at ratios of around 10:1.

翻译：
> ZooKeeper具有非常好的读性能，ZooKeeper更适用于读比写更多的应用，读写比例在 10:1


原文：
> The data stored at each znode in a namespace is read and written
atomically. Reads get all the data bytes associated with a znode and
a write replaces all the data. Each node has an Access Control List (ACL)
that restricts who can do what.

翻译：
> 存储在znode节点里面的数据的读和写都是原子的，读操作将读取该节点下的所有数据，
写操作将替换掉整个节点的所有内容，每个节点都有一个ACL来限制谁可以操作。

### Nodes and ephemeral nodes 节点及临时节点

原文：
> ZooKeeper also has the notion of ephemeral nodes. These znodes exists
as long as the session that created the znode is active.
When the session ends the znode is deleted. Ephemeral nodes are useful
when you want to implement \[tbd\]

翻译：
> ZooKeeper同样具有临时节点的概念, 其生命周期是session开始创建此节点到session结束
该节点就会被删除。


原文：
> ZooKeeper supports the concept of watches. Clients can set a watch
on a znode. A watch will be triggered and removed when the znode changes.
When a watch is triggered, the client receives a packet saying that the
znode has changed. If the connection between the client and one of the
Zoo Keeper servers is broken, the client will receive a local
notification. These can be used to \[tbd\].

翻译：
> ZooKeeper支持watches(监听器)，客户端可以设置一个watch到一个node上, 当znode
发生变化时，watch将会被触发或者被删除。当watch被触发时客户端将收到一条通知告诉客户端
znode已经发生变化了，如果客户端与服务器端的连接断开了，客户端将收到一个本地通知。


原文：
> The replicated database is an in-memory database containing
the entire data tree. Updates are logged to disk for recoverability,
and writes are serialized to disk before they are applied to
the in-memory database.

翻译：
> 所有数据都放在内存中, 更新操作将以日志的形式持久化到磁盘当中，以备服务器出现故障时
进行数据恢复，写操作将会先持久化到磁盘当中再写入内存数据库中。


原文：
> Every ZooKeeper server services clients. Clients connect to exactly
one server to submit irequests. Read requests are serviced from
the local replica of each server database. Requests that change
the state of the service, write requests, are processed by an
agreement protocol.

翻译：
> 客户端只会连接到具体的每一个服务器，读请求将由改服务器直接处理，写或者修改状态的
请求将基于一致性协议来处理。




原文：
> As part of the agreement protocol all write requests from clients
are forwarded to a single server, called the leader. The rest of the
ZooKeeper servers, called followers, receive message proposals from
the leader and agree upon message delivery. The messaging layer
takes care of replacing leaders on failures and syncing followers
with leaders.

翻译：
> 所有写请求将重定向到Leader服务器处理


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>


原文：
>

翻译：
>













原文：
>

翻译：
>





































