package com.zkx.bbs.service;

import com.zkx.bbs.dao.BaseDao;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.util.CommonUtils;
import com.zkx.bbs.util.PasswordHash;
import com.zkx.bbs.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zkx on 2017/3/20.
 */
@Service
public class UserService {

    @Autowired
    private BaseDao<User> userDao;
    private static final String NAMESPACE_USER = "com.zkx.bbs.dao.BBSUserDao";


    /**
     * 插入新用户
     *
     * @param phone
     * @param password
     * @return
     */
    private Long insertUser(String phone, String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(PasswordHash.createHash(password));
        user.setCredits(10);
        user.setLastVisitTime(CommonUtils.getTimeStamp());
        user.setRegisterTime(CommonUtils.getTimeStamp());
        userDao.insert(NAMESPACE_USER + ".insertUser", user);
        return user.getUserId();
    }

    /**
     * 通过手机号查询用户
     *
     * @param phone
     * @return
     */
    public User queryUserByPhone(String phone) {
        if (!StringUtil.isPhone(phone)) {
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("phone", phone);
        return userDao.selectOne(NAMESPACE_USER + ".queryUserByPhone", params);
    }

    /**
     * 通过id查询用户
     *
     * @param userId
     * @return
     */
    public User queryUserById(Long userId) {
        if (CommonUtils.isIdNull(userId)) {
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        User user = userDao.selectOne(NAMESPACE_USER + ".queryUserById", params);// TODO: 2017/8/14
        return user;
    }

    public User queryUserByAccount(String account) {
        return null;// TODO: 2018/3/30
    }

    public List<User> queryUserByKeyword() {
        // TODO: 2018/3/30
        return null;
    }

    /**
     * 更新密码
     *
     * @param userId
     * @param newPwd
     */
    public void updateUserPassword(Long userId, String newPwd) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(newPwd)) {
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("password", newPwd);
        userDao.update(NAMESPACE_USER + ".updateUserPassword", params);// TODO: 2017/8/15
    }


    /*更新积分、最后登录IP、时间*/
//    public void updateLoginInfo(User user) {
//        String sqlStr = "update t_user set credits=?,last_visit=?,last_ip=? where user_id=?";
//        jdbcTemplate.update(sqlStr, new Object[]{user.getCredits(), user.getLastVisit(), user.getLastIp(), user
// .getUserId()});
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
        User user = queryUserById(userId);
        if (user == null) throw new ErrorNoException(BBSErrorNo.USER_NOT_EXIST);
        return user;
    }

    public void updateUserInfo(User user) {
    }


}
