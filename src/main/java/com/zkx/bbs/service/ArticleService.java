package com.zkx.bbs.service;

import com.zkx.bbs.entity.User;
import com.zkx.bbs.entity.ForumZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zkx on 2017/7/31.
 */
@Service
public class ArticleService {
    @Autowired
    private UserService userService;
    @Autowired
    private ZoneService zoneService;

    /**
     * 保存草稿
     *
     * @param userId
     * @param zoneId
     * @param title
     * @param detail
     * @param detailImages
     */
    public void saveDraft(Long userId, Integer zoneId, String title, String detail, String detailImages) {
        User user = userService.queryNormalUser(userId);
        ForumZone forumZone = zoneService.queryNormalZone(zoneId);

    }

    /**
     * 删除文章
     */
    public void deleteArticle(Long userId, Long articleId) {
    }

    /**
     * 发布文章
     */
    public void publishArticle(Long userId, Integer zoneId, String title, String detail) {
    }

    /**
     * 更新文章
     */
    public void updateArticle(Long userId, Long articleId, String title, String detail) {
    }
}
