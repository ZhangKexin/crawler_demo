package com.zkx.bbs.service;

import com.zkx.bbs.common.BBSConstant;
import com.zkx.bbs.dao.LoginLogDao;
import com.zkx.bbs.dao.UserDao;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.entity.app.LoginInfo;
import com.zkx.bbs.entity.app.UserInfo;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.util.PasswordHash;
import com.zkx.bbs.util.UserPassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/3/20.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * 检查用户名密码
     *
     * @return
     */
//    public boolean hasMatchUser(String userName, String password) {
//        int count = userDao.getMatchCount(userName, password);
//        return count == 1;
//    }

    /**
     * 以用户名为条件加载User对象
     *
     * @return
     */
//    public User findUserByUserName(String userName) {
//        User user = userDao.findUserByUserName(userName);
//        return user;
//    }

    /**
     * 登录成功后，更新登录时间、IP，记录登录日志
     */
//    public void loginSuccess(User user) {
//        user.setCredits(user.getCredits() + 5);
//        userDao.updateLoginInfo(user);
//        LoginLog loginLog = new LoginLog();
//        loginLog.setUserId(user.getUserId());
//        loginLog.setIp(user.getLastIp());
//        loginLog.setLoginDate(user.getLastVisit());
//        loginLogDao.insertLoginLog(loginLog);
//    }


    private void checkUser(User user, String password) {
        if (user == null) {
            throw new ErrorNoException(BBSErrorNo.ERR_INVALID_UNAME_OR_PASSWD);
        }
        if (!PasswordHash.validatePassword(password, user.getPassword())) {
            throw new ErrorNoException(BBSErrorNo.ERR_INVALID_UNAME_OR_PASSWD);
        }
    }

    public User queryNormalUser(Long userId) {
        User user = userDao.queryUserById(userId);
        if (user == null) throw new ErrorNoException(BBSErrorNo.USER_NOT_EXIST);
        return user;
    }

    public void updateUserInfo(User user) {
    }

    public void updateUserPassword(Long userId, String newPwd) {
        // TODO: 2017/9/7
    }

    public User queryUserByAccount(String account) {
    }
}
