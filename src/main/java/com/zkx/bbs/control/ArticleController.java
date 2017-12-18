package com.zkx.bbs.control;

import com.zkx.bbs.entity.Result;
import com.zkx.bbs.service.ArticleService;
import com.zkx.bbs.util.CommonUtils;
import com.zkx.bbs.util.LogHome;
import org.apache.commons.lang.StringUtils;
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
        // TODO: 2017/9/3
        articleService.publishArticle(userId, zoneId, title, detail);
        return result;
    }

    @RequestMapping("saveDraft")
    @ResponseBody
    public Result saveDraft(Long userId, Integer zoneId, String title, String detail, String detailImages) {
        if (CommonUtils.isIdNull(userId) || zoneId == null || StringUtils.isBlank(title) || StringUtils.isBlank
                (detail)) {
            LogHome.getLog().error("保存草稿，参数缺失，userId:" + userId + ", zoneId:" + zoneId + ", title:" + title + ", " +
                    "detail:" + detail);
        }
        // TODO: 2017/9/3
        Result result = CommonUtils.generateSuccessResult();
        articleService.saveDraft(userId, zoneId, title, detail, detailImages);
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result deleteArticle(Long userId, Long articleId) {
        Result result = CommonUtils.generateSuccessResult();
        // TODO: 2017/9/3
        articleService.deleteArticle(userId, articleId);
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public Result updateArticle(Long userId, Long articleId, String title, String detail) {
        Result result = CommonUtils.generateSuccessResult();
        // TODO: 2017/9/3
        articleService.updateArticle(userId, articleId, title, detail);
        return result;
    }
}
