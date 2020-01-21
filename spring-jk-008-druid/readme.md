# Alibaba druid

阿里巴巴的数据源，据其说其监控功能特别强大。

druid的扩展点特别多，是通过继承`FilterEventAdapter`类来实现的。

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

## 2. 说明

- application.properties: 使用`druid-spring-boot-starter`时，这里配置了druid数据库连接池的相关配置。也可以不使用这个文件，直接配置DruidDataSource
- spring-configuration-metadata.json: application.properties中有些配置项会被IDEA不识别，配上这个就识别了
- druid-filter.properties: 

## 3. Druid Filter 扩展点

- 继承FilterEventAdapter，实现对druid的扩展: `ConnectionLogFilter`
- resources/META-INF/druid-filter.properties中增加filter配置
