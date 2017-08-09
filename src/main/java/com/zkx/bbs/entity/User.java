package com.zkx.bbs.entity;

import java.io.Serializable;

/**
 * Created by zkx on 2017/3/20.
 */
public class User implements Serializable {
    private Long userId;
    private String userName;
    private String password;
    private String phone;
    private Integer credits;
    private Long lastVisitTime;
    private Integer sex;
    private String signature;
    private String image;
    private Picture imagePic;
    private Long registerTime;
    private Boolean payed;
    private Boolean isBanned;

    public Long getUserId() {
        return userId;
    }

    public User setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getCredits() {
        return credits;
    }

    public User setCredits(Integer credits) {
        this.credits = credits;
        return this;
    }

    public Long getLastVisitTime() {
        return lastVisitTime;
    }

    public User setLastVisitTime(Long lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public User setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public User setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public String getImage() {
        return image;
    }

    public User setImage(String image) {
        this.image = image;
        return this;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public User setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public Boolean getPayed() {
        return payed;
    }

    public User setPayed(Boolean payed) {
        this.payed = payed;
        return this;
    }

    public Boolean getIsBanned() {
        return isBanned;
    }

    public User setIsBanned(Boolean banned) {
        isBanned = banned;
        return this;
    }
}
