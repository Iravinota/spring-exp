# mybatis

可以直接写SQL的JPA框架

## 1. 说明

- application.properties
  - mybatis.type-handlers-package: 指定了Java类型和数据库类型间转换的Handler，这里把Money转为Long存入数据库
  - mybatis.configuration.map-underscore-to-camel-case: 指定了表中列名和Java类中属性名之间的转换方式，下划线转驼峰格式
- CoffeeMapper
  - 是一个interface
  - 定义了如何进行数据库操作
  - 使用注解方式定义
  - insert, update返回影响的条数

## 2. 注解

- @Mapper: 所有mapper上
- @MapperScan("com.ws.exp.spring.mybatis.mapper"): 扫描的mapper目录