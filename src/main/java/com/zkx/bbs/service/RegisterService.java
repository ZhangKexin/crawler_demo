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
        // TODO: 2017/8/9 校验是否注册 
        Long userId = userDao.insertUser(phone, password);
        return userId;
    }

}
