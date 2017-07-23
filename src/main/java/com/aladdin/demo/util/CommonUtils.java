package com.aladdin.demo.util;

/**
 * Created by zkx on 2017/7/23.
 */
public class CommonUtils {

    public boolean isIdNull(Long id) {
        return id == null || id == 0L;
    }

    public Long getTimeStamp() {
        return Long.valueOf(System.currentTimeMillis() / 1000L);
    }
}
