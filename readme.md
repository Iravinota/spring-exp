# Spring Experiment

spring基础配置开发

1. spring-exp-01-basic: 使用基本的XML配置基于maven构建一个简单的Spring工程，包括slf4j, log4j2.
    - IDEA->project setting中，配置facet为spring，可以使用Spring相关IDE
    - com.ws.experiment.spring.basic中的类，和resources/spring/spring-basic.xml，以及test/*/com.ws.experiment.spring.basic中的配置文件，这些是以XML进行Spring开发的基础配置
        - spring/spring-basic.xml是spring配置文件
        - Main.java输出bean相关信息
        - BeanTest输出测试信息
    - com.ws.experiment.spring.annotation中的类和测试文件，是使用annotation方式进行spring开发的配置
    - com.ws.experiment.spring.db中是普通数据库相关操作
    - com.ws.experiment.spring.mybatis中是使用mybatis对数据库进行相关操作
    - maven窗口执行clean清理项目，执行test测试项目，执行install编译并把jar包放到.m2仓库中
2. asdf