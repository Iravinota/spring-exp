# spring caches

Spring自带的cache：基于注解的缓存

长久不变的，页面缓存

## 1. pom.xml

没有特殊的依赖，只需要spring-boot-starter-data-jpa，就会自带对数据库的Cache

## 2. 注解

- SpringBucksApplication
  - @EnableCaching(proxyTargetClass = true): 内部使用AOP对操作进行了拦截，如果使用缓存，则进行缓存处理
- CoffeeService
  - @CacheConfig(cacheNames = "coffee"): 配置缓存。这里配置了名字
  - @Cacheable: 执行方法时，如果结果在缓存中，就直接从缓存中取；若不在缓存，则执行后结果放到缓存中
  - @CacheEvict: 缓存清理