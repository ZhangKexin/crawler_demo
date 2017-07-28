package com.aladdin.demo.common;

import com.aladdin.demo.exception.UserErrorNo;

/**
 * Created by zkx on 2017/3/22.
 */
public class CrawlerConstant {

    public static final String URL_ZHIHU_PREFIX = "https://www.zhihu.com/question";

    public static final UserErrorNo CRAWLER_ERROR_NO = new UserErrorNo();

    public static class Product {
        public static final int APP_DD = 1;
    }
}
