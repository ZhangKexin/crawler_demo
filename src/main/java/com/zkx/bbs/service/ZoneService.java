package com.zkx.bbs.service;

import com.zkx.bbs.dao.ZoneDao;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.entity.Zone;
import com.zkx.bbs.entity.app.ResultMap;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.util.LogHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zkx on 2017/7/30.
 */
@Service
public class ZoneService {
    @Autowired
    private ZoneDao zoneDao;
    @Autowired
    private UserService userService;

    public Map queryZoneList(Long userId) {
        List<Zone> zoneList = zoneDao.queryZoneList();
        Map<String, Object> result = new ResultMap();
        Map<Integer, List<Zone>> zoneMap = new HashMap<>();
        for (Zone zone : zoneList) {
        }
        result.put("zoneList", zoneList);
        return result;
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

    public void saveZone(Long userId, String zoneName, Integer parentId) {
        User user = userService.queryNormalUser(userId);
        if (!user.getIsAdmin()) {
            LogHome.getLog().error("非管理员保存版块，userId:" + userId + ", zoneName");
            throw new ErrorNoException(BBSErrorNo.USER_NOT_ADMIN);
        }
        if (parentId == null || parentId == 0L) {
            zoneDao.saveZone(zoneName, null);
        } else {
            Zone parentZone = zoneDao.queryZoneById(parentId);
            if (parentZone == null || parentZone.getIsDelete()) {
                zoneDao.saveZone(zoneName, null);
            } else {
                zoneDao.saveZone(zoneName, parentZone);
            }
        }
    }
}
