package com.aladdin.demo.service;

import com.aladdin.demo.dao.BaseDao;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/7/30.
 */
@Service
public class ComplainService {

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

   public void complainUser(){

   }
   public void saveComplaint(){}
   public Object queryComplaintResult(){}
}
