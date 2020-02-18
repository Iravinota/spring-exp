# spring redis

使用spring-boot对redis进行操作。这是案例是基于spring-jk-023-springbucks的基础上修改的

## 1. pom.xml

- jedis: 添加redis的client

## 2. 说明

- 通过JedisPool获取Jedis实例，不能直接使用Jedis获取连接，这不是线程安全的
- 直接使用Jedis中的方法