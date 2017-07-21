package com.aladdin.demo.util.serialilzer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by zkx on 2017/7/21.
 */
public class BooleanJsonSerializer extends JsonSerializer<Boolean> {

    public void serialize(Boolean aBoolean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        if (aBoolean != null && aBoolean.booleanValue()) {
            jsonGenerator.writeString("1");
        } else {
            jsonGenerator.writeString("0");
        }
    }
}
