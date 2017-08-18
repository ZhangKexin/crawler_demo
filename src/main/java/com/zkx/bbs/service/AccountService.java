package com.zkx.bbs.service;

import com.zkx.bbs.dao.UserDao;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.util.PasswordHash;
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

    public Long register(String phone, String password) {
        User user = userDao.queryUserByPhone(phone);
        if (user != null) {
            throw new ErrorNoException(BBSErrorNo.USER_REGISTERED_TO_LOGIN);
        }
        Long userId = userDao.insertUser(phone, password);
        return userId;
    }

    public void resetPassword(Long userId, String oldPwd, String newPwd) {
        User user = userService.queryNormalUser(userId);
        if (!PasswordHash.validatePassword(oldPwd, user.getPassword())) {
            throw new ErrorNoException(BBSErrorNo.ERR_INVALID_UNAME_OR_PASSWD);
        }
        // TODO: 2017/8/14 校验newPwd格式
        userDao.updateUserPassword(userId, newPwd);
        
    }


}
