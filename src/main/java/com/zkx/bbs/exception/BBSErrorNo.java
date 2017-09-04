package com.zkx.bbs.exception;

/**
 * Created by zkx on 2017/7/25.
 */
public class BBSErrorNo extends GenericEnum<Integer> {
    private static final long serialVersionUID = 1L;
    public static final int SERVER_INTERNAL_ERROR = 500;

    public static final int ERR_INVALID_TOKEN = 10000;
    public static final int TOKEN_EXPIRE = 10001;
    public static final int ERR_INVALID_SIGN = 10002;
    public static final int SERVER_CONTENT_DELETED = 10004;
    public static final int USER_NOT_EXIST = 10005;
    public static final int CONTAIN_SENSITIVE_WORD = 10006;
    public static final int PARAM_ERROR = 10007;
    public static final int UNAVAILABLE = 10008;
    public static final int COMMENT_DELETED = 10009;
    public static final int USER_REGISTERED_TO_LOGIN = 10010;

    public static final int ERR_INVALID_UNAME_OR_PASSWD = 10011;
    public static final int ERROR_PASSWORD = 10012;


    /*----------ZONE----------*/
    public static final int ZONE_NOT_EXIST = 10100;
    public static final int ZONE_LEVEL_TOO_DEEP = 10101;
    /*----------USER----------*/
    public static final int USER_NOT_ADMIN = 10200;

    public BBSErrorNo() {
        this.putEnum(Integer.valueOf(10000), "无效token");
        this.putEnum(Integer.valueOf(10001), "token过期");
        this.putEnum(Integer.valueOf(500), "服务内部错误");
        this.putEnum(PARAM_ERROR, "参数缺失或格式错误");
        this.putEnum(Integer.valueOf(10002), "非法签名");
        this.putEnum(Integer.valueOf(10005), "用户不存在");
        this.putEnum(Integer.valueOf(10004), "原文已删除");
        this.putEnum(Integer.valueOf(10006), "内容包含敏感词");
        this.putEnum(Integer.valueOf(10008), "暂无查看权限");
        this.putEnum(Integer.valueOf(10009), "该评论已删除");
        this.putEnum(USER_REGISTERED_TO_LOGIN, "用户已注册，直接登录");
        this.putEnum(ERR_INVALID_UNAME_OR_PASSWD, "用户名或密码错误");

        /*----------ZONE----------*/
        this.putEnum(ZONE_NOT_EXIST, "版块不存在");
        this.putEnum(ZONE_LEVEL_TOO_DEEP, "版块过深");

        /*----------USER----------*/
        this.putEnum(USER_NOT_ADMIN, "当前用户非管理员");
    }
}
