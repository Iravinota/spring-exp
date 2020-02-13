package com.ws.exp.spring.jdbc.errorcode;

import org.springframework.dao.DuplicateKeyException;

/**
 * CustomDuplicatedKeyException
 *
 * @author Eric at 2020-02-13_20:31
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {
    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
