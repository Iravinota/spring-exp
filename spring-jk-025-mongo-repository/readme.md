# spring mongodb use Repository

上一节操作mongodb时，只使用了MongoTemplate。这里我们使用Repository来操作mongodb

有一个继承了MongoRepository的interface，就可以实现很多对数据库的操作。

## 1. 变化

- 主函数前添加了@EnableMongoRepositories
- 添加了继承MongoRepository接口的interface
