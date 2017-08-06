package com.zkx.bbs.service;

import com.zkx.bbs.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/7/31.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void saveDraft() {
    }

    public void deleteArticle(Long userId, Long articleId) {
    }

    public void publishArticle(Long userId, Integer zoneId, String title, String detail) {
    }

    public void updateArticle(Long userId, Long articleId, String title, String detail) {
    }
}
