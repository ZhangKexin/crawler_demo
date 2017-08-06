package com.zkx.bbs.entity;

/**
 * Created by zkx on 2017/7/31.
 */
public class Reply {
    private Long replyId;
    private String message;

    private Long parentArticleId;
    private Long userId;
    private Long toUserId;

    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;

}
