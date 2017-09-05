package com.zkx.bbs.service;

import com.zkx.bbs.entity.User;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.util.PasswordHash;
import com.zkx.bbs.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/8/23.
 */
@Service
public class UserSecurityService {
    @Autowired
    private UserService userService;
    @Autowired
    private SmsService smsService;

    /**
     * 校验旧密码
     */
    public void checkRawPassword(Long userId, String rawPwd) {
        // TODO: 2017/8/23
    }

    /**
     * 更换密码
     */
    public void modifyPassword(Long userId, String rawPwd, String newPwd) {
        User user = userService.queryNormalUser(userId);
        // TODO: 2017/8/23
        if (!PasswordHash.validatePassword(rawPwd, user.getPassword())) {
            throw new ErrorNoException(BBSErrorNo.ERR_INVALID_UNAME_OR_PASSWD);
        }
    }

    /**
     * 更换手机号——校验旧手机号
     */
    public void checkPhone(Long userId, String phone) {
        // TODO: 2017/8/23
    }

    /**
     * 发送验证码:
     * 3. 修改手机号
     */
    public void sendCaptcha(Long userId, String phone) {
        // TODO: 2017/8/23
        User user = userService.queryNormalUser(userId);
        if (StringUtil.isPhone(phone)) {
            smsService.sendCaptcha(phone);
        }
    }

    /**
     * 发送验证码:
     * 1. 注册
     * 2. 忘记密码
     */
    public void sendCaptcha(String phone) {
        // TODO: 2017/8/23
        if (StringUtil.isPhone(phone)) {
            smsService.sendCaptcha(phone);

        }
    }

    /**
     * 更换手机号
     */
    public void mofifyPhone(Long userId, String phone, String captcha) {
        // TODO: 2017/8/23  
    }

    /**
     * 重置密码
     */
    public void resetPassword(Long userId, String newPwd) {
        User user = userService.queryNormalUser(userId);

        // TODO: 2017/8/14 校验newPwd格式
        userService.updateUserPassword(userId, newPwd);

    }
}
