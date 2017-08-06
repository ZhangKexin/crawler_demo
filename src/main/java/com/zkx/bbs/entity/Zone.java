package com.zkx.bbs.entity;

/**
 * Created by zkx on 2017/7/30.
 */
public class Zone {
    /**
     * gc_zone:
     * zone_id
     * name
     * level
     * parent_id
     * is_delete
     * create_time
     * update_time
     */
    private Integer zoneId;
    private String name;
    private Integer level;
    private Integer parentId;
    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;

    public Integer getZoneId() {
        return zoneId;
    }

    public Zone setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Zone setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public Zone setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Zone setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public Zone setIsDelete(Boolean delete) {
        isDelete = delete;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Zone setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Zone setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
