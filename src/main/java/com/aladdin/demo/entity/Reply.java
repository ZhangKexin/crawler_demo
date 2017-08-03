package com.aladdin.demo.entity;

/**
 * Created by zkx on 2017/7/31.
 */
public class Reply {
    private Long replyId;
    private String content;

    private Long parentArticleId;
    private Long userId;
    private Long toUserId;

    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;

}
