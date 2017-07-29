package com.aladdin.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zkx on 2017/3/20.
 */
public class User implements Serializable {
    private Long userId;
    private String userName;
    private String password;
    private String phone;
    private int credits;
    private String lastIp;
    private Date lastVisit;
    private Integer sex;
    private String signature;
    private String image;
    private String imageUrl;
    private Picture imagePic;
    private Long registerTime;
    private Boolean payed;

    public Boolean getPayed() {
        return payed;
    }

    public User setPayed(Boolean payed) {
        this.payed = payed;
        return this;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public User setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public String getImage() {
        return image;
    }

    public User setImage(String image) {
        this.image = image;
        this.imagePic =;
        this.imageUrl =;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public User setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public User setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getPhone() {

        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

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

    public int getCredits() {
        return credits;
    }

    public User setCredits(int credits) {
        this.credits = credits;
        return this;
    }

    public String getLastIp() {
        return lastIp;
    }

    public User setLastIp(String lastIp) {
        this.lastIp = lastIp;
        return this;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public User setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
        return this;
    }
}
