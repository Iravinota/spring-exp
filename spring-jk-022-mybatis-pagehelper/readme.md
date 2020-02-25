# mybatis pagehelper

pagehelper是一个国人编写的分页组件。对从数据库中查出来的数据进行分页。

## 1. pom.xml

- 添加pagehelper-spring-boot-starter依赖
- mybatis-spring-boot-starter自带spring-boot-starter依赖，所以加不加都行

## 2. pagehelper使用说明

- pom.xml中添加依赖
- application.properties中添加配置属性
- 通过RowBounds或者@Param参数使用pagehelper，参看CoffeeMapper。这里和mybatis进行联合处理，使用了mybatis中的东西
