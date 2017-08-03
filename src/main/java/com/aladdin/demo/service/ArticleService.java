package com.aladdin.demo.service;

import com.aladdin.demo.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/7/31.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
}
