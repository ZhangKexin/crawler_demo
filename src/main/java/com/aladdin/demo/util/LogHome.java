package com.aladdin.demo.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by zkx on 2017/7/25.
 */
public class LogHome {

    public LogHome() {
    }

    public static Log getLog() {
        return LogFactory.getLog(LogHome.class);
    }

    public static Log getLog(Class cls) {
        return LogFactory.getLog(cls);
    }

    public static Log getLog(String name) {
        return LogFactory.getLog(name);
    }
}
