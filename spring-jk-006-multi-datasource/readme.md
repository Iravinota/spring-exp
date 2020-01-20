# spring boot 006 - multi datasource

配置多个数据源

## 1. 说明

- pom.xml:
  - spring-boot-starter-actuator: 监控
  - spring-boot-starter-jdbc: jdbc
  - spring-boot-starter-web: web mvc
  - h2: database
  - lombok: tool for log
- resources/applicaton.properties
  - foo datasource
  - bar datasource
- MultiDataSourceDemoApplication
  - @SpringBootApplication中需要去掉自动jdbc配置
  - 在这个类中，我们手动对datasource进行配置
  - `@ConfigurationProperties("foo.datasource")`指明了需要使用哪个配置项配置数据源
  - 这里的`DataSourceProperties`类都是spring boot中的类，自动配置的DataSource是`com.zaxxer.hikari.HikariDataSource`