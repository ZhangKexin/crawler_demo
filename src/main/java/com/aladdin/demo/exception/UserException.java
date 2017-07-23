package com.aladdin.demo.exception;

/**
 * Created by zkx on 2017/7/23.
 */
public class UserException extends RuntimeException {
    private static final long serialVersionUID = 1747159748002286865L;

    public UserException() {
    }

    public UserException(String msg) {
        super(msg);
    }

    public UserException(Exception e) {
        super(e);
    }
}
