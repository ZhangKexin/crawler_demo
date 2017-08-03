package com.aladdin.demo.entity.app;

import com.aladdin.demo.entity.Picture;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * Created by zkx on 2017/7/31.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ArticleInfo {
    private Long articleId;
    private Long userId;

    private Long parentArticleId;

    private String title;
    private String images;
    private List<Picture> imageList;
    private String location;

    private Integer replyNum;
    private Integer zanNum;
    private Boolean isTop;

    private Long updateTime;
    private String fmtUpdateTime;

}
