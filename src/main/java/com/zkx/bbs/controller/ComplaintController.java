package com.zkx.bbs.controller;

import com.zkx.bbs.entity.Result;
import com.zkx.bbs.service.ComplaintService;
import com.zkx.bbs.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zkx on 2017/7/30.
 */
@Controller
@RequestMapping("v1/complain")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("user")
    @ResponseBody
    public Result complainUser(Long userId, Long toUserId, String message, String images) {
        Result result = CommonUtils.generateSuccessResult();
        // TODO: 2017/9/3
        complaintService.complainUser(userId, toUserId, message, images);
        return result;
    }

    @RequestMapping("article")
    @ResponseBody
    public Result complainArticle(Long userId, Long articleId, String message, String images) {
        Result result = CommonUtils.generateSuccessResult();
        // TODO: 2017/9/3
        complaintService.complainArticle(userId, articleId, message, images);
        return result;
    }


}
