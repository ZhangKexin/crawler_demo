package com.zkx.bbs.util.serialilzer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by zkx on 2017/7/21.
 */
public class IntegerJsonSerializer extends JsonSerializer<Integer> {

    public void serialize(Integer aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
            IOException, JsonProcessingException {
        if (aLong == null) {
            jsonGenerator.writeString("0");
        } else {
            jsonGenerator.writeString(String.valueOf(aLong));
        }
    }
}
