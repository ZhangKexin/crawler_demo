package com.zkx.bbs.controller;

import com.zkx.bbs.entity.Result;
import com.zkx.bbs.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zkx on 2017/8/21.
 */
@Controller
@RequestMapping("v1/security")
public class SecurityController {

    @RequestMapping("checkRawPwd")
    @ResponseBody
    public Result checkRawPassword(Long userId, String rawPwd) {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

    @RequestMapping("modifyPwd")
    @ResponseBody
    public Result modifyPwd(Long userId, String rawPwd, String newPwd) {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

    @RequestMapping("modifyPhone")
    @ResponseBody
    public Result modifyPhone(Long userId, String phone, String captcha) {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

    @RequestMapping("")
    @ResponseBody
    public Result f() {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

    @RequestMapping("")
    @ResponseBody
    public Result f() {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

    @RequestMapping("")
    @ResponseBody
    public Result f() {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

    @RequestMapping("")
    @ResponseBody
    public Result f() {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }

    @RequestMapping("")
    @ResponseBody
    public Result f() {
        Result result = CommonUtils.generateSuccessResult();
        return result;
    }
}
