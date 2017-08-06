package com.zkx.bbs.exception;


import com.zkx.bbs.common.CrawlerConstant;

public class ErrorNoException extends RuntimeException {

    private static final long serialVersionUID = 1747159748002286866L;

    private int errorNo;

    public ErrorNoException() {
        super();
    }

    public ErrorNoException(Integer errorNo) {
        super(CrawlerConstant.CRAWLER_ERROR_NO.getName(errorNo));
        this.errorNo = errorNo;
    }

    public ErrorNoException(Exception e) {
        super(e);
    }

    public int getErrorNo() {
        return errorNo;
    }
}
