package com.zkx.bbs.service;

import com.zkx.bbs.dao.BaseDao;
import com.zkx.bbs.entity.Complaint;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/7/30.
 */
@Service
public class ComplaintService {

    /**
     * gc_complain:
     * complain_id
     * user_id
     * to_id
     * to_complain_type
     * message
     * images
     * is_delete
     * create_time
     * update_time
     */
    BaseDao<Complaint> complainDao;

    public void complainUser(Long userId, Long toUserId, String message, String images) {

    }

    public void saveComplaint() {
    }

    public Object queryComplaintResult() {
        return null;
    }

    public void complainArticle(Long userId, Long articleId, String message, String images) {
    }
}
