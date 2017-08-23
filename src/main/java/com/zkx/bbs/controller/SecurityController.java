package com.zkx.bbs.controller;

import com.zkx.bbs.entity.Result;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.service.UserSecurityService;
import com.zkx.bbs.util.CommonUtils;
import com.zkx.bbs.util.LogHome;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zkx on 2017/8/21.
 */
@Controller
@RequestMapping("v1/security")
public class SecurityController {
    @Autowired
    private UserSecurityService securityService;

    /**
     * 发送验证码
     */
    @RequestMapping("sendCaptcha")
    @ResponseBody
    public Result sendCaptcha(Long userId, String phone) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(phone)) {
            LogHome.getLog().error("更换手机号发送验证码，参数错误，userId:" + userId + ", phone:" + phone);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        securityService.sendCaptcha(userId, phone);
        return result;
    }

    /**
     * 校验验证码
     */
    @RequestMapping("validateCaptcha")
    @ResponseBody
    public Result validateCaptcha(Long userId, String phone, String captcha) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(phone) || StringUtils.isBlank(captcha)) {
            LogHome.getLog().error("校验验证码，参数错误, userId:" + userId + ", phone:" + phone + ", captcha:" + captcha);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }
    /*---------------修改密码------------------*/

    /**
     * 校验旧密码
     */
    @RequestMapping("checkRawPwd")
    @ResponseBody
    public Result checkRawPassword(Long userId, String rawPwd) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(rawPwd) || rawPwd.trim().length() > 20 ||
                rawPwd.trim().length() < 6) {
            LogHome.getLog().error("校验旧密码，参数错误，userId:" + userId + ", rawPwd:" + rawPwd);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        securityService.checkRawPassword(userId, rawPwd);
        return result;
    }

    /**
     * 更换新密码
     */
    @RequestMapping("modifyPwd")
    @ResponseBody
    public Result modifyPwd(Long userId, String rawPwd, String newPwd) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(rawPwd) || StringUtils.isBlank(newPwd) ||
                newPwd.trim().length() > 20 || newPwd.trim().length() < 6) {
            LogHome.getLog().error("更换密码，参数错误，userId:" + userId + ", rawPwd:" + rawPwd + ", newPwd:" + newPwd);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        securityService.modifyPassword(userId, rawPwd, newPwd);
        return result;
    }

    /*------------忘记密码-------------*/

    /**
     * 重置密码
     */
    @RequestMapping("resetPwd")
    @ResponseBody
    public Object resetPassword(Long userId, String newPwd) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(newPwd)) {
            LogHome.getLog().error("重置密码参数缺失，userId:" + userId + ", newPwd:" + newPwd);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        securityService.resetPassword(userId, newPwd);
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

    /*--------------更换手机号-----------------*/

    /**
     * 更换手机号-校验手机号
     */
    @RequestMapping("changePhone/checkPhone")
    @ResponseBody
    public Result checkPhone(Long userId, String phone) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(phone)) {
            LogHome.getLog().error("更换手机号校验旧手机号，参数错误，userId:" + userId + ", phone:" + phone);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        securityService.checkPhone(userId, phone);
        return result;
    }

    /**
     * 更换手机号
     */
    @RequestMapping("changePhone/modifyPhone")
    @ResponseBody
    public Result modifyPhone(Long userId, String phone, String captcha) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(phone) || StringUtils.isBlank(captcha)) {
            LogHome.getLog().error("更换手机号，参数错误，userId:" + userId + ", phone:" + phone + ", captcha:" + captcha);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        securityService.mofifyPhone(userId, phone, captcha);
        return result;
    }
}
