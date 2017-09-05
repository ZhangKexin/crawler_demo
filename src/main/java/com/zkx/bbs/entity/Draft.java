package com.zkx.bbs.entity;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by zkx on 2017/8/3.
 */
public class Draft {
    private Long draftId;
    private Long userId;
    private String title;
    private String detail;
    private String images;
    private List<Picture> imageList;
    private Integer zoneId;
    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;

    public String getImages() {
        return images;
    }

    public Draft setImages(String images) {
        this.images = images;
        this.imageList = JSON.parseArray(images, Picture.class);
        return this;
    }

    public List<Picture> getImageList() {
        return imageList;
    }

    public Draft setImageList(List<Picture> imageList) {
        return this;
    }

    public Long getDraftId() {
        return draftId;
    }

    public Draft setDraftId(Long draftId) {
        this.draftId = draftId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Draft setTitle(String title) {
        this.title = title;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Draft setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Draft setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public Draft setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public Draft setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Draft setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Draft setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
