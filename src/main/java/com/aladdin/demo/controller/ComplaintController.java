package com.aladdin.demo.controller;

import com.aladdin.demo.entity.Result;
import com.aladdin.demo.service.ComplainService;
import com.aladdin.demo.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zkx on 2017/7/30.
 */
@Controller
@RequestMapping("v1/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @RequestMapping("user")
    @ResponseBody
    public Result complainUser(Long userId, Long toUserId, String message,String images) {
        Result result = CommonUtils.generateSuccessResult();
        complainService.complainUser(userId, toUserId, message,images);
        return result;
    }@RequestMapping("article")
    @ResponseBody
    public Result complainArticle(Long userId, Long articleId, String message, String images) {
        Result result = CommonUtils.generateSuccessResult();
        complainService.complainArticle(userId, articleId, message,images);
        return result;
    }@RequestMapping("user")
    @ResponseBody
    public Result complainUser(Long userId, Long toUserId, String message,String images) {
        Result result = CommonUtils.generateSuccessResult();
        complainService.complainUser(userId, toUserId, message);
        return result;
    }@RequestMapping("user")
    @ResponseBody
    public Result complainUser(Long userId, Long toUserId, String message) {
        Result result = CommonUtils.generateSuccessResult();
        complainService.complainUser(userId, toUserId, message);
        return result;
    }


}
