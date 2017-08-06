package com.zkx.bbs.controller;

import com.zkx.bbs.entity.Result;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.service.UserService;
import com.zkx.bbs.util.CommonUtils;
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
