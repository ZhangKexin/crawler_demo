package com.zkx.bbs.controller;

import com.zkx.bbs.entity.LoginCommand;
import com.zkx.bbs.entity.Result;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.entity.app.LoginInfo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.exception.UserErrorNo;
import com.zkx.bbs.service.UserService;
import com.zkx.bbs.util.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by zkx on 2017/3/20.
 */
@Controller
@RequestMapping("v1")
public class LoginController {
    @Autowired
    private UserService userService;

//    @RequestMapping("")
//    @ResponseBody
//    public Object hello() {
//        return "hello";
//    }
//
//    @RequestMapping("/index.html")
//    public String loginPage() {
//        return "login";
//    }
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
            throw new ErrorNoException(UserErrorNo.PARAM_EMPTY);
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


}
