package com.aladdin.demo.controller;

import com.aladdin.demo.entity.Result;
import com.aladdin.demo.service.ArticleService;
import com.aladdin.demo.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zkx on 2017/7/29.
 */
@Controller
@RequestMapping("v1/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("publish")
    @ResponseBody
    public Result publishArticle(Long userId, Integer zoneId, String title, String detail) {
        Result result = CommonUtils.generateSuccessResult();
        articleService.publishArticle(userId, zoneId, title, detail);
        return result;
    }
    @RequestMapping("saveDraft")
    @ResponseBody
    public Result saveDraft(Long userId, Long zoneId,String title, String detail, ){
        Result result = CommonUtils.generateSuccessResult();
        articleService.saveDraft();
    }
    @RequestMapping("delete")
    @ResponseBody
    public Result deleteArticle(Long userId, Long articleId) {
        Result result = CommonUtils.generateSuccessResult();
        articleService.deleteArticle(userId, articleId);
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public Result updateArticle(Long userId, Long articleId, String title, String detail) {
        Result result = CommonUtils.generateSuccessResult();
        articleService.updateArticle(userId, articleId, title, detail);
    }
}
