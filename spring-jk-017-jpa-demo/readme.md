# jpa demo

简单的jpa操作，使用hibernate

## 1. pom.xml

- spring-boot-starter-data-jpa: jpa相关类
- joda-money: 金融中对金额处置十分敏感，这个类处置金额
- usertype.core: 上面那个需要这个类

## 2. Application

- CommandLineRunner: 其中的run接受的和main中一样的参数
- ApplicationRunner: 和CommandLineRunner一样，都是使用run进行回调。这不过这里的参数是封装过的，可以直接处理参数

## 3. 常用JPA注解

- 实体
  - @Entity: 对实体注释。任何Hibernate映射对象都要有这个注释
  - @Table(name): 声明此对象映射到数据库的数据表，通过它可以为实体指定表(talbe),目录(Catalog)和schema的名字。该注释不是必须的，如果没有则系统使用默认值(实体的短类名)
- 主键
  - @Id: 声明此属性为主键
  - @GeneratedValue(strategy, generator): 设置主键的生成策略，这种方式依赖于具体的数据库，如果数据库不支持自增主键，那么这个类型是没法用的
    - TABLE：使用表保存id值
    - IDENTITY：identity column
    - SEQUENCR ：sequence
    - AUTO：根据数据库的不同使用上面三个
  - @SequenceGenerator(name, sequenceName)
- 映射
  - @Column(name, nullable, length, insertable, updatable): 声明该属性与数据库字段的映射关系
  - @JoinTable(name)
  - @JoinColumn(name)
  - @Transitent: 当POJO有属性不需要映射的时候一定要用@Transitent修饰，该注释表示此属性与表没有映射关系，只是一个暂时的属性。
  - @Type: 告知数据库中存储哪种类型
  - @CreationTimestamp: 创建时间戳。当执行插入操作时，自动向数据库中插入一个时间戳
  - @UpdateTimestamp: 更新时间戳。当执行更新操作时，自动向数据库中插入一个时间戳
- 关系
  - @OneToOne
  - @OneToMany
  - @ManyToOne
  - @ManyToMany
  - @OrderBy

## 4. lombok辅助的注解

- @Builder: lombok自动创建这个类的builder
- @Data: lombok自动设置@Setter @Getter @ToString
- @NoArgsConstructor: lombok自动设置无参构造函数
- @AllArgsConstructor: lombok自动设置全参构造函数
- @RequiredArgsConstructor
- @Slf4j, @CommonsLog, @Log4j2: 日志

## 参考资料

- [Hibernate Annotations](https://docs.jboss.org/hibernate/stable/annotations/reference/en/html_single/)
- [Spring Data JPA中常用的注解详解](https://www.jianshu.com/p/1b759ef26ff3)
- [SPRING中常用的注解](https://www.cnblogs.com/hoojjack/p/6568920.html)
- [CommandLineRunner或者ApplicationRunner接口](https://www.jianshu.com/p/5d4ffe267596)
- [java – 了解hibernate @Type注释](http://www.voidcn.com/article/p-wprbpuzn-bue.html)
- [【hibernate】常用注解](https://www.cnblogs.com/yangchongxing/p/10357118.html)
