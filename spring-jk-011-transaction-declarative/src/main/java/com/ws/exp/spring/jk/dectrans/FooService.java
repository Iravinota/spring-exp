package com.ws.exp.spring.jk.dectrans;

/**
 * FooService
 *
 * @author Eric at 2020-02-13_17:09
 */
public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;
}
