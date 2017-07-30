package com.aladdin.demo.entity.app;

import com.aladdin.demo.util.serialilzer.IntegerJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
}
