package com.zkx.bbs.service;

import com.zkx.bbs.dao.ZoneDao;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.entity.Zone;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.util.LogHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/7/30.
 */
@Service
public class ZoneService {
    @Autowired
    private ZoneDao zoneDao;
    @Autowired
    private UserService userService;

    public Object queryZoneList(Long userId) {
        return zoneDao.queryZoneList();
    }

    // TODO: 2017/8/25
    public Zone queryNormalZone(Integer zoneId) {
        Zone zone = zoneDao.queryZoneById(zoneId);
        if (zone == null || zone.getIsDelete()) {
            LogHome.getLog().error("版块不存在，zoneId:" + zoneId);
            throw new ErrorNoException(BBSErrorNo.ZONE_NOT_EXIST);
        }
        return zone;
    }

    public Object saveZone(Long userId, String zoneName, Integer parentId) {
        User user =userService.queryNormalUser(userId);
        user.is
    }
}
