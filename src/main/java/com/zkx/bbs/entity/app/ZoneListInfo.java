package com.zkx.bbs.entity.app;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ZoneListInfo {
    List<ZoneInfo> zoneList;

    public List<ZoneInfo> getZoneList() {
        return zoneList;
    }

    public ZoneListInfo setZoneList(List<ZoneInfo> zoneList) {
        this.zoneList = zoneList;
        return this;
    }
}
