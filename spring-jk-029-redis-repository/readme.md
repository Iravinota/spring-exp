# Spring redis repository

## 1. 说明

- SpringBucksApplication
  - redisCustomConversions: bean, 设置redis存和取的自定义的转换器
  - @EnableRedisRepositories
- CoffeeCache
  - @RedisHash(value = "springbucks-coffee", timeToLive = 60)
  - @Indexed
- @WritingConverter   // 写入转换
- @ReadingConverter   // 读取时的转换器。从Redis中读取数据时，把byte[]转换为Money
