package com.zkx.bbs.control;

import com.zkx.bbs.common.BBSConstant;
import com.zkx.bbs.entity.Result;
import com.zkx.bbs.entity.app.LoginInfo;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.service.AccountService;
import com.zkx.bbs.service.UserService;
import com.zkx.bbs.util.CommonUtils;
import com.zkx.bbs.util.LogHome;
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
    private AccountService accountService;

    /**
     * 注册
     */
    @RequestMapping("register")
    @ResponseBody
    public Object register(@RequestParam(required = true) String phone,
                           @RequestParam(required = true) String password) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(password) ||
                password.trim().length() < BBSConstant.STRING_LENGTH.PASSWORD_LENGTH_MIN ||
                password.trim().length() > BBSConstant.STRING_LENGTH.PASSWORD_LENGTH_MAX) {
            LogHome.getLog().error("注册参数缺失，phone:" + phone + ", password:" + password);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        accountService.register(phone, password);
        return result;
    }



    /**
     * 续费
     *
     * @param userId
     * @return
     */
    @RequestMapping("pay")
    @ResponseBody
    public Object pay(Long userId) {
        Result result = CommonUtils.generateSuccessResult();
        // TODO: 2017/8/25  
        return result;
    }


}
