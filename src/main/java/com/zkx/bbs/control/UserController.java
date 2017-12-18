package com.zkx.bbs.control;

import com.zkx.bbs.entity.Result;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.service.UserService;
import com.zkx.bbs.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户controller
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
        // TODO: 2017/9/3
        userService.updateUserInfo(user);
        return result;
    }
}
