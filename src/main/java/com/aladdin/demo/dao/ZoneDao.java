package com.aladdin.demo.dao;

import org.springframework.stereotype.Component;

/**
 * Created by zkx on 2017/7/30.
 */
@Component
public class ZoneDao {
    /**
     * gc_zone:
     * zone_id
     * name
     * level
     * parent_id
     * is_delete
     * create_time
     * update_time
     */

    BaseDao<Zone> zoneDao;

    public List<Zone> queryZoneList() {
    }

    public List<Zone> queryZoneList(Long zoneId) {
    }
}
