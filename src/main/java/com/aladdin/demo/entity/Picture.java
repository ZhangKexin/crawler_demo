package com.aladdin.demo.entity;

/**
 * Created by zkx on 2017/7/30.
 */
public class Picture {
    private String url;
    private Float height;
    private Float width;

    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    public Float getHeight() {
        return height;
    }

    public Picture setHeight(Float height) {
        this.height = height;
        return this;
    }

    public Float getWidth() {
        return width;
    }

    public Picture setWidth(Float width) {
        this.width = width;
        return this;
    }
}
