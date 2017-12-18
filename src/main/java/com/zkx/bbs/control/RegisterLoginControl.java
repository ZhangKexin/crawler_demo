package com.zkx.bbs.control;

import com.zkx.bbs.entity.Result;
import com.zkx.bbs.entity.app.LoginInfo;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.service.LoginService;
import com.zkx.bbs.service.UserService;
import com.zkx.bbs.util.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller(value = "v1/")
public class RegisterLoginControl {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;


    /**
     * 注册
     *
     * @param password
     * @return
     */
    @RequestMapping(value = "register")
    @ResponseBody
    public Object register(@RequestParam(required = true) String account, @RequestParam(required = true) String password,
            String platform, String appVersion) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }   LoginInfo loginInfo = loginService.login(account, password, platform, appVersion);
        Result result = CommonUtils.generateSuccessResult();
        result.setData(loginInfo);
        return result;
    }
    /**
     * 登录
     *
     * @param password
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public Object login(@RequestParam(required = true) String account, @RequestParam(required = true) String password,
            String platform, String appVersion) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }   LoginInfo loginInfo = loginService.login(account, password, platform, appVersion);
        Result result = CommonUtils.generateSuccessResult();
        result.setData(loginInfo);
        return result;
    }

    /**
     * token检查
     *
     * @param ddtoken
     * @return
     */
    @RequestMapping(value = "check")
    @ResponseBody
    public Object checkToken(@RequestParam(required = true) String ddtoken) {
        Result result = CommonUtils.generateSuccessResult();
        Map<String, Object> map = loginService.checkToken(ddtoken);
        result.setData(map);
        return result;
    }

    /**
     * 登出
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public Object logout(String ddtoken, Long userId) {
        loginService.logout(ddtoken, userId);
        return CommonUtils.generateSuccessResult();
    }

}
