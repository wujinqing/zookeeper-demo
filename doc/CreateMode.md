## org.apache.zookeeper.CreateMode源码API doc翻译


### public enum CreateMode

> CreateMode值决定节点如何在ZooKeeper服务器中创建

### PERSISTENT

> 创建一个持久化的节点，当连接断开了之后节点不会被删除。

### PERSISTENT_SEQUENTIAL

> 创建一个持久化的有序的节点(节点将会追加一个单调递增的数字)，当连接断开了之后节点不会被删除。

### EPHEMERAL

> 创建一个临时的节点，当连接断开了之后节点将会被自动删除。

### EPHEMERAL_SEQUENTIAL

> 创建一个临时的有序的节点(节点将会追加一个单调递增的数字)，当连接断开了之后节点将会被自动删除。

### static public CreateMode fromFlag(int flag) throws KeeperException
> 将数字转换为CreateMode枚举值

> 0 -> PERSISTENT

> 1 -> EPHEMERAL

> 2 -> PERSISTENT_SEQUENTIAL

> 3 -> EPHEMERAL_SEQUENTIAL

























