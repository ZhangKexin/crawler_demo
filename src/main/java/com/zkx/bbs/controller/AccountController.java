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
//
//    @RequestMapping("/loginCheck.html")
//    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
//        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
//        if (!isValidUser) {
//            return new ModelAndView("login", "error", "用户名或密码错误");
//        }
//        User user = userService.findUserByUserName(loginCommand.getUserName());
//        user.setLastIp(request.getRemoteAddr());
//        user.setLastVisit(new Date());
//        userService.loginSuccess(user);
//
//        request.getSession().setAttribute("user", user);
//        return new ModelAndView("main");
//    }

    @RequestMapping("login")
    @ResponseBody
    public Object login(@RequestParam(required = false) String username, @RequestParam(required = false) String
            phone, String password) {
        if ((StringUtils.isBlank(username) && StringUtils.isBlank(phone)) || StringUtils.isBlank(password)) {
            throw new ErrorNoException(UserErrorNo.PARAM_ERROR);
        }
        LoginInfo loginInfo = userService.login(username, phone, password);
        Result result = CommonUtils.generateSuccessResult();
        result.setData(loginInfo);
        return result;
    }

    @RequestMapping("recharge")
    @ResponseBody
    public Object recharge(Long userId) {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

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

}
