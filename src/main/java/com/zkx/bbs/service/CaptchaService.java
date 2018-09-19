package com.zkx.bbs.service;

import com.zkx.bbs.dao.BaseDao;
import com.zkx.bbs.entity.Captcha;
import com.zkx.bbs.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by zkx on 2017/8/23.
 */
@Repository
public class CaptchaService {

    @Autowired
    private BaseDao<Captcha> captchaDao;

    private static final String NAMESPACE_CAPTCHA = "";// TODO: 2017/8/23

    public Captcha insertCaptcha(String phone, String code) {
        Captcha captcha = new Captcha();
        captcha.setPhone(phone).setCode(code).setTime(CommonUtils.getTimeStamp());
        captchaDao.insert(NAMESPACE_CAPTCHA+".insertCaptcha", captcha);
        return captcha;
    }

    public Captcha queryCaptcha(String phone){
        return null;// TODO: 2017/9/13  
    }
}
