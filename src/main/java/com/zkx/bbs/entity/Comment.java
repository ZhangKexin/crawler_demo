package com.zkx.bbs.entity;

public class Comment {

    private String rowId;
    private Long commentId;
    private Long themeId;
    private Long userId;
    private Long rawCommentId;
    private int replyNum;
    private String content;
    private Long toCommentId;
    private Long toUserId;
    private boolean isDelete;
    private Long createTime;
    private Long updateTime;

    public Long getCommentId() {
        return commentId;
    }

    public Comment setCommentId(Long commentId) {
        this.commentId = commentId;
        return this;
    }

    public Long getThemeId() {
        return themeId;
    }

    public Comment setThemeId(Long themeId) {
        this.themeId = themeId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Comment setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRawCommentId() {
        return rawCommentId;
    }

    public Comment setRawCommentId(Long rawCommentId) {
        this.rawCommentId = rawCommentId;
        return this;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public Comment setReplyNum(int replyNum) {
        this.replyNum = replyNum;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public Long getToCommentId() {
        return toCommentId;
    }

    public Comment setToCommentId(Long toCommentId) {
        this.toCommentId = toCommentId;
        return this;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public Comment setToUserId(Long toUserId) {
        this.toUserId = toUserId;
        return this;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public Comment setDelete(boolean delete) {
        isDelete = delete;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Comment setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Comment setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getRowId() {
        return rowId;
    }

    public Comment setRowId(String rowId) {
        this.rowId = rowId;
        return this;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "rowId='" + rowId + '\'' +
                ", commentId=" + commentId +
                ", themeId=" + themeId +
                ", userId=" + userId +
                ", rawCommentId=" + rawCommentId +
                ", replyNum=" + replyNum +
                ", content='" + content + '\'' +
                ", toCommentId=" + toCommentId +
                ", toUserId=" + toUserId +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
