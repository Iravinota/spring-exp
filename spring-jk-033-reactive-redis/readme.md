# reactive redis

以reactive方式操作redis

## 1. pom.xml

- spring-boot-starter-data-redis-reactive

## 2. 说明

- 只有Lettuce客户端才支持reactive方式
- ReactiveRedisConnection: 建立reactive连接
- ReactiveRedisConnectionFactory: 用来构造上面的连接
- ReactiveRedisTemplate: 模板类
