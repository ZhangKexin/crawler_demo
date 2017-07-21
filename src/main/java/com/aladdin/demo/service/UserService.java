package com.aladdin.demo.service;

import com.aladdin.demo.dao.LoginLogDao;
import com.aladdin.demo.dao.UserDao;
import com.aladdin.demo.entity.LoginLog;
import com.aladdin.demo.entity.User;
import com.aladdin.demo.entity.app.LoginInfo;
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
    public boolean hasMatchUser(String userName, String password) {
        int count = userDao.getMatchCount(userName, password);
        return count == 1;
    }

    /**
     * 以用户名为条件加载User对象
     *
     * @return
     */
    public User findUserByUserName(String userName) {
        User user = userDao.findUserByUserName(userName);
        return user;
    }

    /**
     * 登录成功后，更新登录时间、IP，记录登录日志
     */
    public void loginSuccess(User user) {
        user.setCredits(user.getCredits() + 5);
        userDao.updateLoginInfo(user);
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLogDao.insertLoginLog(loginLog);
    }

    public LoginInfo login(String userName, String phone, String password) {

    }
}
