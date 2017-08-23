package com.zkx.bbs.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created by zkx on 2017/7/21.
 */
public class StringUtil {
    public static Boolean isPhone(String phone) {
        if (StringUtils.isBlank(phone)) return false;
        phone = phone.replaceAll("-", "").replaceAll(" ", "").replace("+86", "");
        return phone.matches("^1\\d{10}$");
    }
}
