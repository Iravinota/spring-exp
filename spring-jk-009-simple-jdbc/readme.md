# Simple JDBC

spring boot支持的简单的jdbc操作

## 1. 说明

- pom.xml
  - spring-boot-starter-jdbc
  - h2
  - lombok
  - spring-boot-starter-test: 测试
- FooDao:
  - SimpleJdbcInsert: 更方便使用jdbc insert的辅助类

## 2. spring中通过注解定义bean

- @Component: 通用注解
- @Repository: 一般是数据库操作bean，dao层，**数据操作仓库**
- @Service: 业务服务
- @Controller: spring mvc
- @RestController: RESTful服务