package com.aladdin.demo.service;

import com.aladdin.demo.dao.ZoneDao;
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
}
