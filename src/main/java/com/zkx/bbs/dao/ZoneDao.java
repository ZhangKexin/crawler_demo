package com.zkx.bbs.dao;

import com.zkx.bbs.common.BBSConstant;
import com.zkx.bbs.entity.Zone;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.util.CommonUtils;
import com.zkx.bbs.util.LogHome;
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

    public void saveZone(String zoneName, Zone parentZone) {
        Zone zone = new Zone();
        if (parentZone != null) {
            if (parentZone.getLevel() == BBSConstant.MAX_ZONE_LEVEL) {
                LogHome.getLog().error("新建版块过深，zoneName:" + zoneName + ", parentZone:" + parentZone);
                throw new ErrorNoException(BBSErrorNo.ZONE_LEVEL_TOO_DEEP);
            }
            zone.setParentId(parentZone.getZoneId()).setLevel(parentZone.getLevel() + 1);
        }
        zone.setName(zoneName).setCreateTime(CommonUtils.getTimeStamp()).setUpdateTime(CommonUtils.getTimeStamp());
        zoneDao.insert(NAMESPACE_ZONE + ".insertZone", zone);// TODO: 2017/9/4
    }

    public List<Zone> queryZoneList() {
        return zoneDao.selectList(NAMESPACE_ZONE + ".queryZoneList");
    }// TODO: 2017/9/4

    public List<Zone> queryZoneList(Long zoneId) {
        return zoneDao.selectList(NAMESPACE_ZONE + ".queryZoneListByZoneId", zoneId);// TODO: 2017/9/4
    }

    public Zone queryZoneById(Integer zoneId) {
        if (zoneId == null || zoneId == 0) return null;
        return zoneDao.selectOne(NAMESPACE_ZONE + ".queryZoneById", zoneId);// TODO: 2017/9/4
    }
}
