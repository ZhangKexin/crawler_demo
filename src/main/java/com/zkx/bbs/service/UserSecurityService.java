package com.zkx.bbs.service;

import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/8/23.
 */
@Service
public class UserSecurityService {

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
        // TODO: 2017/8/23
    }

    /**
     * 更换手机号——校验旧手机号
     */
    public void checkPhone(Long userId, String phone) {
        // TODO: 2017/8/23
    }

    /**
     * 发送验证码
     */
    public void sendCaptcha(Long userId, String phone) {
        // TODO: 2017/8/23  
    }

    /**
     * 更换手机号
     */
    public void mofifyPhone(Long userId, String phone, String captcha) {
        // TODO: 2017/8/23  
    }
}
