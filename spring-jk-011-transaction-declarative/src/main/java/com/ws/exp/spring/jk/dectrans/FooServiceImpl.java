package com.ws.exp.spring.jk.dectrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * FooServiceImpl
 *
 * @author Eric at 2020-02-13_17:10
 */
@Component  // 这个注解致命这是一个bean
public class FooServiceImpl implements FooService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional  // 这是一个事务
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO(BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)   // 函数抛出RollbackException时，回滚
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO(BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    // 直接调用一个函数。因为本函数没有添加事务，spring中注解驱动的事务实际上是spring对类做的代理，所以这里不会有显示的事务，只会使用数据库自身的隐式事务
    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
    }
}
