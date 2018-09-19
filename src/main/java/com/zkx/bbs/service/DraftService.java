package com.zkx.bbs.service;

import com.zkx.bbs.dao.BaseDao;
import com.zkx.bbs.entity.Draft;
import com.zkx.bbs.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DraftService {

    @Autowired
    private BaseDao<Draft> draftDao;

    private static final String NAMESPACE_DRAFT = "";// TODO: 2017/8/25

    public Draft insertDraft(Long userId, Integer zoneId, String title, String detail, String images) {
        Draft draft = new Draft();
        draft.setUserId(userId)
                .setTitle(title)
                .setDetail(detail)
                .setImages(images)
                .setZoneId(zoneId)
                .setCreateTime(CommonUtils.getTimeStamp())
                .setUpdateTime(CommonUtils.getTimeStamp());
        draftDao.insert(NAMESPACE_DRAFT + ".insertDraft", draft);
        return draft;
    }
}
