package com.aladdin.crawler_demo.controller;

import com.aladdin.crawler_demo.entity.LoginCommand;
import com.aladdin.crawler_demo.entity.User;
import com.aladdin.crawler_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by zkx on 2017/3/20.
 */
@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("")
    @ResponseBody
    public Object hello(){
        return "hello";
    }

    @RequestMapping("/index.html")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (!isValidUser) {
            return new ModelAndView("login", "error", "用户名或密码错误");
        }
        User user = userService.findUserByUserName(loginCommand.getUserName());
        user.setLastIp(request.getRemoteAddr());
        user.setLastVisit(new Date());
        userService.loginSuccess(user);

        request.getSession().setAttribute("user", user);
        return new ModelAndView("main");
    }
}
