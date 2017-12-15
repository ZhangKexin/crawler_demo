package com.zkx.bbs.entity.app;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ThemeListInfo {
    List<ThemeInfo> zoneList;

    public List<ThemeInfo> getZoneList() {
        return zoneList;
    }

    public ThemeListInfo setZoneList(List<ThemeInfo> zoneList) {
        this.zoneList = zoneList;
        return this;
    }
}
