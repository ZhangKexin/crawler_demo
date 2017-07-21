package com.aladdin.demo.entity;

import com.aladdin.demo.util.serialilzer.IntegerJsonSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by zkx on 2017/7/21.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    @JsonSerialize(using = IntegerJsonSerializer.class)
    private Integer status;
    private String msg;
    private Object data;

    public Result() {
    }

    public int getStatus() {
        return this.status.intValue();
    }

    public Result setStatus(int status) {
        this.status = Integer.valueOf(status);
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
