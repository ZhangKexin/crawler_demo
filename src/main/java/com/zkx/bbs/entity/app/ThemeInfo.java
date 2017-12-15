package com.zkx.bbs.entity.app;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zkx.bbs.util.serialilzer.IntegerJsonSerializer;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ThemeInfo {
    @JsonSerialize(using = IntegerJsonSerializer.class)
    private Integer zoneId;
    private String name;
    @JsonSerialize(using = IntegerJsonSerializer.class)
    private Integer level;
    @JsonSerialize(using = IntegerJsonSerializer.class)
    private Integer parentId;

    private List<ThemeInfo> subZoneList;

    public List<ThemeInfo> getSubZoneList() {
        return subZoneList;
    }

    public ThemeInfo setSubZoneList(List<ThemeInfo> subZoneList) {
        this.subZoneList = subZoneList;
        return this;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public ThemeInfo setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ThemeInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public ThemeInfo setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public ThemeInfo setParentId(Integer parentId) {
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
