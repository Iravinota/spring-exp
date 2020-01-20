# spring极客时间005 - 如何配置单数据源

## 1. 说明

- 从<https://start.spring.io/>上建立并下载工程(其实不需要，直接创建maven项目即可)，需要的相关项为
  - acurator：查看spring-boot状态
  - h2: 简单数据库
  - jdbc: spring-boot-start-jdbc
  - lombok: 需要在IDEA中安装lombok插件，这样可以自动写log
  - web: spring-boot-starter-web，web必备组件
- 执行BasicApplication.java，启动spring-boot。它会启动一个内置的Tomcat，监听8080端口
- 启动程序后，acurator查看系统状态（Chrome安装`JSON viewer`插件可以方便查看json报文）：
  - <http://localhost:8080/actuator/beans> 查看所有的bean
  - <http://localhost:8080/actuator/health> 查看系统状态
- resources/application.properties设置spring-boot的一些参数
- 配置数据：spring-boot会自动扫描`resource/`目录，把其中的`schema.sql`用于创建数据库表，`data.sql`用于创建数据

## 2. spring-boot功能

在BasicApplication.java中，spring-boot帮我们实现了一些功能：

- [DataSourceAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/jdbc/DataSourceAutoConfiguration.html): 帮我们自动配置了DataSource
- [DataSourceTransactionManagerAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/jdbc/DataSourceTransactionManagerAutoConfiguration.html): 帮我们自动配置了DataSourceTransactionManager 
- JdbcTemplateAutoConfiguration: 配置JdbcTemplate
- 符合条件时才进行配置，按需配置：例如我自己配置了DataSource，就不会再自动配置了