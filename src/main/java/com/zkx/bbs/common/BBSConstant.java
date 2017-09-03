package com.zkx.bbs.common;


import com.zkx.bbs.exception.BBSErrorNo;

/**
 * Created by zkx on 2017/3/22.
 */
public class BBSConstant {

    public static final String URL_ZHIHU_PREFIX = "https://www.zhihu.com/question";

    public static final BBSErrorNo BBS_ERROR_NO = new BBSErrorNo();

    public static class Product {
        public static final int APP_DD = 1;
    }

    public class STRING_LENGTH {
        public static final int PASSWORD_LENGTH_MIN = 8;
        public static final int PASSWORD_LENGTH_MAX = 30;
    }
}
