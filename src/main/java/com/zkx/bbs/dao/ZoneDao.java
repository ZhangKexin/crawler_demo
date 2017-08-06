package com.zkx.bbs.dao;

import com.zkx.bbs.entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
@Component
public class ZoneDao {

    @Autowired
    private BaseDao<Zone> zoneDao;

    // TODO: 2017/7/30
    private static final String NAMESPACE_ZONE = "";

    public List<Zone> queryZoneList() {
        return zoneDao.selectList(NAMESPACE_ZONE + ".queryZoneList");
    }

    public List<Zone> queryZoneList(Long zoneId) {
        return zoneDao.selectList(NAMESPACE_ZONE + ".queryZoneListByZoneId", zoneId);
    }
}
