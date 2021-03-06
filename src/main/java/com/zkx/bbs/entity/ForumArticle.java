package com.zkx.bbs.entity;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
public class ForumArticle {
    private Long articleId;
    private Long userId;

    private Long parentArticleId;

    private String title;
    private String images;
    private List<Picture> imageList;
    private String location;
    private Double longitude;
    private Double latitude;

    private Boolean isTop;

    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;


    public Double getLongitude() {
        return longitude;
    }

    public ForumArticle setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public ForumArticle setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Long getParentArticleId() {

        return parentArticleId;
    }

    public ForumArticle setParentArticleId(Long parentArticleId) {
        this.parentArticleId = parentArticleId;
        return this;
    }

    public Long getArticleId() {
        return articleId;
    }

    public ForumArticle setArticleId(Long articleId) {
        this.articleId = articleId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public ForumArticle setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ForumArticle setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImages() {
        return images;
    }

    public ForumArticle setImages(String images) {
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

    public ForumArticle setLocation(String location) {
        this.location = location;
        return this;
    }

    public Boolean getTop() {
        return isTop;
    }

    public ForumArticle setTop(Boolean top) {
        isTop = top;
        return this;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public ForumArticle setDelete(Boolean delete) {
        isDelete = delete;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public ForumArticle setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public ForumArticle setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
