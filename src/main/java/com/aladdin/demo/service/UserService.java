package com.aladdin.demo.service;

import com.aladdin.demo.common.CrawlerConstant;
import com.aladdin.demo.dao.LoginLogDao;
import com.aladdin.demo.dao.UserDao;
import com.aladdin.demo.entity.LoginLog;
import com.aladdin.demo.entity.User;
import com.aladdin.demo.entity.app.LoginInfo;
import com.aladdin.demo.entity.app.UserInfo;
import com.aladdin.demo.exception.UserErrorNo;
import com.aladdin.demo.exception.ErrorNoException;
import com.aladdin.demo.util.PasswordHash;
import com.aladdin.demo.util.UserPassUtils;
import org.apache.commons.lang.StringUtils;
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
        User user = new User();
        if (StringUtils.isNotBlank(phone)) {
            user = userDao.queryUserByPhone(phone);
        }
        if (StringUtils.isNotBlank(userName)) {
            user = userDao.queryUserByUserName(userName);
        }
        checkUser(user, password);

        String token = UserPassUtils.generateCookie(user, CrawlerConstant.Product.APP_DD);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId())
                .setPhone(user.getPhone())
                .setSex()
                .setSignature()
                .setUserImage()
                .setUserName();

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setToken(token)
                .setUserInfo(userInfo);
        return loginInfo;
    }

    private void checkUser(User user, String password) {
        if (user == null) {
            throw new ErrorNoException(UserErrorNo.ERR_INVALID_UNAME_OR_PASSWD);
        }
        if (!PasswordHash.validatePassword(password, user.getPassword())) {
            throw new ErrorNoException(UserErrorNo.ERR_INVALID_UNAME_OR_PASSWD);
        }
    }
}
