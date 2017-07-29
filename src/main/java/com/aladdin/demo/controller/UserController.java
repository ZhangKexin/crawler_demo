package com.aladdin.demo.controller;

import com.aladdin.demo.entity.Result;
import com.aladdin.demo.entity.User;
import com.aladdin.demo.service.UserService;
import com.aladdin.demo.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zkx on 2017/7/29.
 */
@Controller
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    @ResponseBody
    public Result updateUserInfo(User user) {
        Result result = CommonUtils.generateSuccessResult();
        userService.updateUserInfo(user);
        return result;
    }
}
