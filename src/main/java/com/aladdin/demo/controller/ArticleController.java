package com.aladdin.demo.controller;

import com.aladdin.demo.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zkx on 2017/7/29.
 */
@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("")
    public Result publishArticle(Long userId, String){

    }

}
