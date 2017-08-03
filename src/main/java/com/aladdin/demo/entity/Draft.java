package com.aladdin.demo.entity;

/**
 * Created by zkx on 2017/8/3.
 */
public class Draft {
    private Long draftId;
    private String title;
    private Long userId;
    private String detail;
    private Long zoneId;
    private Long isDelete;
    private Long createTime;
    private Long updateTime;

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

    public Long getZoneId() {
        return zoneId;
    }

    public Draft setZoneId(Long zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    public Draft setIsDelete(Long isDelete) {
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
