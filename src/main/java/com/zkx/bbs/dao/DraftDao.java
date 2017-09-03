package com.zkx.bbs.dao;

import com.zkx.bbs.entity.Draft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DraftDao {

    @Autowired
    private BaseDao<Draft> draftDao;

    private static final String NAMESPACE_DRAFT = "";// TODO: 2017/8/25

    public Draft insertDraft(Long userId, Integer zoneId, String title, String detail, String detailImages) {
        Draft draft = new Draft();
        draft.set
    }
}
