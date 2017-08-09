package com.zkx.bbs.service;

import com.zkx.bbs.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/8/9.
 */
@Service
public class RegisterService {

    @Autowired
    private UserDao userDao;

    public Long register(String phone, String password) {
        Long userId = userDao.insertUser(phone, password);
        return userId;
    }

}
