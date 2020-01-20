# Alibaba druid

阿里巴巴的数据源，据其说其监控功能特别强大

## 1. 配置pom.xml

注意要把spring-boot-starter-jdbc中默认的HikariCP连接池排除掉，并且引入druid

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
    <exclusions>
        <exclusion>
            <artifactId>HikariCP</artifactId>
            <groupId>com.zaxxer</groupId>
        </exclusion>
    </exclusions>
</dependency>
```

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.10</version>
</dependency>
```
