package com.aladdin.demo.entity.app;

import com.aladdin.demo.util.serialilzer.IntegerJsonSerializer;
import com.aladdin.demo.util.serialilzer.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by zkx on 2017/7/20.
 */
public class UserInfo {
    @JsonSerialize(using = LongJsonSerializer.class)
    private Long userId;
    private String userName;
    private String userImage;
    private String signature;
    @JsonSerialize(using = IntegerJsonSerializer.class)
    private int sex;
    private String phone;
    @JsonSerialize(using = LongJsonSerializer.class)
    private Long registerTime;
    private String fmtRegisterTime;

    public Long getRegisterTime() {
        return registerTime;
    }

    public UserInfo setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public String getFmtRegisterTime() {
        return fmtRegisterTime;
    }

    public UserInfo setFmtRegisterTime(String fmtRegisterTime) {
        this.fmtRegisterTime = fmtRegisterTime;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserInfo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserImage() {
        return userImage;
    }

    public UserInfo setUserImage(String userImage) {
        this.userImage = userImage;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public UserInfo setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public UserInfo setSex(int sex) {
        this.sex = sex;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserInfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
