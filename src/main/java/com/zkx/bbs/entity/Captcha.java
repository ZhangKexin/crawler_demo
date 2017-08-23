package com.zkx.bbs.entity;

/**
 * Created by zkx on 2017/8/23.
 */
public class Captcha {
    private Long captchaId;
    private String phone;
    private String code;
    private Long time;

    public Long getCaptchaId() {
        return captchaId;
    }

    public Captcha setCaptchaId(Long captchaId) {
        this.captchaId = captchaId;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Captcha setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Captcha setCode(String code) {
        this.code = code;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public Captcha setTime(Long time) {
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "Captcha{" +
                "captchaId=" + captchaId +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", time=" + time +
                '}';
    }
}
