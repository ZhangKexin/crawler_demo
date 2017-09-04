package com.zkx.bbs.entity.app;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;

@SuppressWarnings("unchecked")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResultMap extends HashMap {

    private static final long serialVersionUID = 1L;

    @Override
    public Object put(Object key, Object value) {
        if (value instanceof Number) {
            return super.put(key, String.valueOf(value));
        }
        if (value instanceof Boolean) {
            Boolean bValue = (Boolean) value;
            if (bValue) {
                return super.put(key, "1");
            } else {
                return super.put(key, "0");
            }
        }
        return super.put(key, value);
    }
}
