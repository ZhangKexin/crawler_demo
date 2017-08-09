package com.zkx.bbs.controller;

import com.zkx.bbs.common.BBSConstant;
import com.zkx.bbs.entity.Result;
import com.zkx.bbs.entity.app.LoginInfo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.exception.UserErrorNo;
import com.zkx.bbs.service.RegisterService;
import com.zkx.bbs.service.UserService;
import com.zkx.bbs.util.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zkx on 2017/3/20.
 */
@Controller
@RequestMapping("v1")
public class AccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private RegisterService registerService;

    @RequestMapping("register")
    @ResponseBody
    public Object register(@RequestParam(required = true) String phone,
            @RequestParam(required = true) String password) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(password) ||
                password.trim().length() < BBSConstant.STRING_LENGTH.PASSWORD_LENGTH_MIN ||
                password.trim().length() > BBSConstant.STRING_LENGTH.PASSWORD_LENGTH_MAX) {
            throw new ErrorNoException(UserErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        registerService.register(phone, password);
        return result;
    }

    @RequestMapping("login")
    @ResponseBody
    public Object login(@RequestParam(required = true) String phone, String password) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(password)) {
            throw new ErrorNoException(UserErrorNo.PARAM_ERROR);
        }
        LoginInfo loginInfo = userService.login(phone, password);
        Result result = CommonUtils.generateSuccessResult();
        result.setData(loginInfo);
        return result;
    }

    @RequestMapping("pay")
    @ResponseBody
    public Object pay(Long userId) {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }


}
