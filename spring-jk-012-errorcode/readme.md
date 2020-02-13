# jdbc错误码

## 1. 错误码

jdbc把所有数据库的错误码都进行了分类，按照其逻辑指定了不同的异常抛出。

这是通过在org/springframework/jdbc/support/sql-error-codes.xml中配置了对不同数据库异常返回码的解析。

通过重写这个文件，就可以设置自己的异常处理。

这里我们通过resources/sql-error-codes.xml，对某些错误码抛出了CustomDuplicatedKeyException异常。

## 2. 测试

在test中进行了测试

- @SpringBootTest(classes = com.ws.exp.spring.jdbc.errorcode.Application.class) 需要用classes指出SpringBootApplication
- 或者test文件和SpringBootApplication文件在同一个目录结构中