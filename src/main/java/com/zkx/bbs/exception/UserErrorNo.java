package com.zkx.bbs.exception;

/**
 * Created by zkx on 2017/7/25.
 */
public class UserErrorNo extends SysErrorNo {

    public static final int ERR_INVALID_UNAME_OR_PASSWD = 1010;

    public UserErrorNo() {
        super();
        this.putEnum(ERR_INVALID_UNAME_OR_PASSWD, "用户名或密码错误");
    }
}
