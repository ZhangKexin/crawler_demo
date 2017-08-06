package com.zkx.bbs.entity;

/**
 * Created by zkx on 2017/7/30.
 */
public class Picture {
    private String url;
    private Integer height;
    private Integer width;

    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Picture setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Picture setWidth(Integer width) {
        this.width = width;
        return this;
    }
}
