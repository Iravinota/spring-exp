# mybatis generator

使用mybatis generator自动生成mybatis程序

如果需要对生成的内容进行修改，最好保存两套，这样自动生成的东西还是可以自动生成的。

## 1. mybatis generator使用说明（使用java程序生成）

- pom.xml中添加mybatis-generator-core
- com.ws.exp.spring.mybatis.generator.MyGenerator执行后，会生成mybatis程序
  - 程序中设置了根据resources/generatorConfig.xml配置文件，生成mybatis程序
- resources/generatorConfig.xml
  - 本项目是在一个project中的module，所以targetProject中，需要设置成"./spring-jk-021-mybatis-generator/xxxx"的格式，才能正常生成
  - 由于使用了H2数据库，所以需要使用SpringBootApplication的形式，自动加载shcema.sql完成对H2数据库的初始化
  
## 2. 说明

- Application.java中，使用generateArtifacts()自动生成mybatis
- Application.java中，使用playWithArtifacts()测试