package com.aladdin.demo.entity;

import java.util.List;

/**
 * Created by zkx on 2017/7/30.
 */
public class Article {
    private Long articleId;
    private Long userId;

    private String title;
    private String images;
    private List<Picture> imageList;
    private String location;

    private Boolean isTop;

    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;



}
