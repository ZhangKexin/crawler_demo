package com.zkx.bbs.entity.app;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zkx.bbs.util.serialilzer.IntegerJsonSerializer;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ZoneInfo {
    @JsonSerialize(using = IntegerJsonSerializer.class)
    private Integer zoneId;
    private String name;
    @JsonSerialize(using = IntegerJsonSerializer.class)
    private Integer level;
    @JsonSerialize(using = IntegerJsonSerializer.class)
    private Integer parentId;

    private List<ZoneInfo> subZoneList;

    public List<ZoneInfo> getSubZoneList() {
        return subZoneList;
    }

    public ZoneInfo setSubZoneList(List<ZoneInfo> subZoneList) {
        this.subZoneList = subZoneList;
        return this;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public ZoneInfo setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ZoneInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public ZoneInfo setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public ZoneInfo setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    @Override
    public String toString() {
        return "ZoneInfo{" +
                "zoneId=" + zoneId +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", subZoneList=" + subZoneList +
                '}';
    }
}
