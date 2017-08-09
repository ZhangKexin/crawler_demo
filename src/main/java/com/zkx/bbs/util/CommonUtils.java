package com.zkx.bbs.util;


import com.zkx.bbs.entity.Result;

/**
 * Created by zkx on 2017/7/23.
 */
public class CommonUtils {

    public boolean isIdNull(Long id) {
        return id == null || id == 0L;
    }

    public static Long getTimeStamp() {
        return Long.valueOf(System.currentTimeMillis() / 1000L);
    }

    public static Result generateSuccessResult(String msg) {
        Result result = new Result();
        result.setStatus(1);
        result.setMsg(msg);
        return result;
    }

    public static Result generateSuccessResult() {
        return generateSuccessResult("成功");
    }

    public static Result generateErrorResult(String msg) {
        Result result = new Result();
        result.setStatus(0);
        result.setMsg(msg);
        return result;
    }

    public static Result generateErrorResult(int errorNo, String msg) {
        Result result = new Result();
        result.setStatus(errorNo);
        result.setMsg(msg);
        return result;
    }
}
