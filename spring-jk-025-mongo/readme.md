# spring mongodb

mongodb是一个文档数据库，是NoSQL的一种。

NoSQL分为四大类：

1. k-v型的，如redis, memorycached
2. 文档型，如mongodb
3. 列存储，HBase
4. NewSQL

Spring Data MongoDB实现对mongodb的支持：MongoTemplate, Repository支持

注解：@Document, @Id

spring.data.mongodb.uri=mongodb://springbucks:springbucks@localhost:27071/springbucks 用来设置连接mongodb数据库

## 1. pom.xml

- spring-boot-starter-data-mongodb:实现mongodb支持

## 2. 注解

- @Document: 标记这个类对应着一个文档
- @Id: mongodb中每个文档都有一个id，标记这个类中哪个字段是id 

## 3. 使用Docker创建mongodb

参看[Windows10安装docker的经验](https://segmentfault.com/n/1330000021776544)，
以及[AWS EC2 redhat 8中安装docker](https://segmentfault.com/n/1330000021771662)
