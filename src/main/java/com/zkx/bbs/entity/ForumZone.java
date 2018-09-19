package com.zkx.bbs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"isDelete", "createTime", "updateTime"})
public class ForumZone {
    public static final int MAX_ZONE_LEVEL = 2;

    private Integer zoneId;
    private String name;
    private Integer level;
    private Integer parentId;
    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;

    private List<ForumZone> subForumZoneList;


    public List<ForumZone> getSubForumZoneList() {
        return subForumZoneList;
    }

    public void setSubForumZoneList(List<ForumZone> subForumZoneList) {
        this.subForumZoneList = subForumZoneList;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public ForumZone setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ForumZone setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public ForumZone setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public ForumZone setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public ForumZone setIsDelete(Boolean delete) {
        isDelete = delete;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public ForumZone setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public ForumZone setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "zoneId=" + zoneId +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", subZoneList=" + subForumZoneList +
                '}';
    }
}
