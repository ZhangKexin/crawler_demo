package com.zkx.bbs.entity;

/**
 * Created by zkx on 2017/8/5.
 */
public class Complaint {
    enum ComplainType {
        USER, ARTICLE, REPLY
    }

    private Long complaintId;
    private Long userId;
    private Long toId;
    private Integer complainType;
    private String message;
    private Integer isReplied;
    private Integer isSolved;

    private Boolean isDelete;
    private Long createTime;
    private Long updateTime;

    public Long getComplaintId() {
        return complaintId;
    }

    public Complaint setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Complaint setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getToId() {
        return toId;
    }

    public Complaint setToId(Long toId) {
        this.toId = toId;
        return this;
    }

    public Integer getComplainType() {
        return complainType;
    }

    public Complaint setComplainType(Integer complainType) {
        this.complainType = complainType;
        return this;
    }

    public Integer getIsReplied() {
        return isReplied;
    }

    public Complaint setIsReplied(Integer isReplied) {
        this.isReplied = isReplied;
        return this;
    }

    public Integer getIsSolved() {
        return isSolved;
    }

    public Complaint setIsSolved(Integer solved) {
        this.isSolved = solved;
        return this;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public Complaint setIsDelete(Boolean delete) {
        isDelete = delete;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Complaint setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Complaint setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
