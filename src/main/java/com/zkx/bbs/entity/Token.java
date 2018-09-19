package com.zkx.bbs.entity;

public class Token {// TODO: 2018/3/30  
    private Long userId;
    private String userPhone;
    private int product;
    private Long rand;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public Long getRand() {
        return rand;
    }

    public void setRand(Long rand) {
        this.rand = rand;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Token [userId=");
        builder.append(userId);
        builder.append(", userPhone=");
        builder.append(userPhone);
        builder.append(", product=");
        builder.append(product);
        builder.append(", rand=");
        builder.append(rand);
        builder.append("]");
        return builder.toString();
    }
}
