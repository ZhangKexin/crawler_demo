package com.zkx.bbs.entity.app;

/**
 * Created by zkx on 2017/7/20.
 */
public class LoginInfo {
    private String token;
    private UserInfo userInfo;

    public String getToken() {
        return token;
    }

    public LoginInfo setToken(String token) {
        this.token = token;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public LoginInfo setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "token='" + token + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
