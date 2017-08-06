package com.zkx.bbs.service;

import com.zkx.bbs.dao.ZoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/7/30.
 */
@Service
public class ZoneService {
    @Autowired
    private ZoneDao zoneDao;

    public Object queryZoneList(Long userId) {
        return zoneDao.queryZoneList();
    }

    public void freeZone(Integer zoneId) {

    }

    public void freezeZone(Integer zoneId) {
    }
}
