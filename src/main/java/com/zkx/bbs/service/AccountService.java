package com.zkx.bbs.service;

import com.zkx.bbs.entity.User;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/8/9.
 */
@Service
public class AccountService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    /**
     * 注册
     */
    public Long register(String phone, String password) {
        User user = userDao.queryUserByPhone(phone);
        if (user != null) {
            throw new ErrorNoException(BBSErrorNo.USER_REGISTERED_TO_LOGIN);
        }
        Long userId = userDao.insertUser(phone, password);
        return userId;
    }


}
