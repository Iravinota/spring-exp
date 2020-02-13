# transaction 事务

## 1. 声明式事务

- @EnableTransactionManagement 启用事务
- @Transactional 添加到函数上，表示这个函数中的所有操作是一个事务
- @Transactional(rollbackFor = RollbackException.class) 函数抛出RollbackException时，回滚
- 直接调用一个函数。因为本函数没有添加事务，spring中注解驱动的事务实际上是spring对类做的代理，所以这里不会有显示的事务，只会使用数据库自身的隐式事务

## 2. 函数式事务

- 参看spring-jk-011-transaction-programmatic\src\main\java\com\ws\exp\spring\jk\protrans\ProgrammaticTransactionDemoApplication.java
- 使用TransactionTemplate控制事务，具体使用TransactionCallback和TransactionCallbackWithoutResult进行事务控制
- 还可以使用PlatformTransactionManager进行事务控制
