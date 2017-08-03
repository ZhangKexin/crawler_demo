package com.aladdin.demo.entity;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
public class Article {
    private Long articleId;
    private Long userId;

    private Long parentArticleId;

    private String title;
    private String images;
    private List<Picture> imageList;
    private String location;

    private Boolean isTop;

    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;

    public Long getArticleId() {
        return articleId;
    }

    public Article setArticleId(Long articleId) {
        this.articleId = articleId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Article setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImages() {
        return images;
    }

    public Article setImages(String images) {
        this.images = images;
        if (StringUtils.isNotBlank(images)) {
            this.imageList = JSON.parseArray(images, Picture.class);
        }
        return this;
    }

    public List<Picture> getImageList() {
        return imageList;
    }

    public String getLocation() {
        return location;
    }

    public Article setLocation(String location) {
        this.location = location;
        return this;
    }

    public Boolean getTop() {
        return isTop;
    }

    public Article setTop(Boolean top) {
        isTop = top;
        return this;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public Article setDelete(Boolean delete) {
        isDelete = delete;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Article setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Article setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
