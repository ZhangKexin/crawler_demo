package com.zkx.bbs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by zkx on 2017/3/20.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties()
public class User {
    private Long userId;
    private String userName;
    private String password;
    private String phone;
    private Integer credits;
    private Long lastVisitTime;
    private String fmtLastVisitTime;
    private Integer sex;
    private String signature;
    private String image;
    private Long registerTime;
    private Boolean payed;
    private Boolean isBanned;
    private Boolean isAdmin;


    public String getFmtLastVisitTime() {
        return fmtLastVisitTime;
    }

    public void setFmtLastVisitTime(String fmtLastVisitTime) {
        this.fmtLastVisitTime = fmtLastVisitTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Long getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Long lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    public Boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Boolean banned) {
        isBanned = banned;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", credits=" + credits +
                ", lastVisitTime=" + lastVisitTime +
                ", sex=" + sex +
                ", signature='" + signature + '\'' +
                ", image='" + image + '\'' +
                ", registerTime=" + registerTime +
                ", payed=" + payed +
                ", isBanned=" + isBanned +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
