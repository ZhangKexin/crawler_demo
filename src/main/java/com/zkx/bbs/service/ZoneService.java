package com.zkx.bbs.service;

import com.zkx.bbs.common.BBSConstant;
import com.zkx.bbs.dao.BaseDao;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.entity.ForumZone;
import com.zkx.bbs.entity.app.ResultMap;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.util.CommonUtils;
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
    private UserService userService;
    @Autowired
    private BaseDao<ForumZone> zoneDao;

    // TODO: 2017/7/30
    private static final String NAMESPACE_ZONE = "";

    public void saveZone(Long userId, String zoneName, Integer parentId) {
        User user = userService.queryNormalUser(userId);
        if (!user.getIsAdmin()) {
            LogHome.getLog().error("非管理员保存版块，userId:" + userId + ", zoneName");
            throw new ErrorNoException(BBSErrorNo.USER_NOT_ADMIN);
        }
        if (parentId == null || parentId == 0L) {
            this.saveZone(zoneName, null);
        } else {
            ForumZone parentForumZone = this.queryZoneById(parentId);
            if (parentForumZone == null || parentForumZone.getIsDelete()) {
                throw new ErrorNoException(BBSErrorNo.ZONE_NOT_EXIST);
            } else {
                saveZone(zoneName, parentForumZone);
            }
        }
    }

    private ForumZone queryZoneById(Integer zoneId) {
        if (zoneId == null || zoneId == 0) return null;
        return zoneDao.selectOne(NAMESPACE_ZONE + ".queryZoneById", zoneId);// TODO: 2017/9/4
    }

    public List<ForumZone> queryAllZoneList(Long userId) {
        return zoneDao.selectList(NAMESPACE_ZONE + ".queryAllZoneList");
        // TODO: 2017/9/4
    }

//-------------------------------------

    public void saveZone(String zoneName, ForumZone parentForumZone) {
        ForumZone forumZone = new ForumZone();
        if (parentForumZone != null) {
            if (parentForumZone.getLevel() == BBSConstant.MAX_ZONE_LEVEL) {
                LogHome.getLog().error("新建版块过深，zoneName:" + zoneName + ", parentZone:" + parentForumZone);
                throw new ErrorNoException(BBSErrorNo.ZONE_LEVEL_TOO_DEEP);
            }
            forumZone.setParentId(parentForumZone.getZoneId()).setLevel(parentForumZone.getLevel() + 1);
        }
        forumZone.setName(zoneName).setCreateTime(CommonUtils.getTimeStamp()).setUpdateTime(CommonUtils.getTimeStamp());
        zoneDao.insert(NAMESPACE_ZONE + ".insertZone", forumZone);// TODO: 2017/9/4
    }


    public List<ForumZone> queryZoneList(Long zoneId) {
        return zoneDao.selectList(NAMESPACE_ZONE + ".queryZoneListByZoneId", zoneId);// TODO: 2017/9/4
    }


    public Map queryZoneList(Long userId) {
        List<ForumZone> forumZoneList = zoneDao.queryZoneList();
        Map<String, Object> result = new ResultMap();
        Map<Integer, List<ForumZone>> zoneMap = new HashMap<>();
        for (ForumZone forumZone : forumZoneList) {
        }
        result.put("zoneList", forumZoneList);
        return result;
    }

    // TODO: 2017/8/25
    public ForumZone queryNormalZone(Integer zoneId) {
        ForumZone forumZone = zoneDao.queryZoneById(zoneId);
        if (forumZone == null || forumZone.getIsDelete()) {
            LogHome.getLog().error("版块不存在，zoneId:" + zoneId);
            throw new ErrorNoException(BBSErrorNo.ZONE_NOT_EXIST);
        }
        return forumZone;
    }


}
