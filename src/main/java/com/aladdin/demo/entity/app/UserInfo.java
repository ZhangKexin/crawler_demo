package com.aladdin.demo.entity.app;

import com.aladdin.demo.util.serialilzer.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by zkx on 2017/7/20.
 */
public class UserInfo {
    @JsonSerialize(using = LongJsonSerializer.class)
    private Long userId;
    private String showName;
    private String userName;
    private String userImage;
    private String nickName;
    private String signature;
    private String thirdPartyCode;
    @JsonSerialize(
            using = IntegerJsonSerializer.class
    )
    private int sex;
    private String userPhone;
    private String remarkName;
    private String userAccount;
    @JsonSerialize(
            using = IntegerJsonSerializer.class
    )
    private Integer provinceId;
    @JsonSerialize(
            using = IntegerJsonSerializer.class
    )
    private Integer cityId;
    private String province;
    private String city;
    @JsonSerialize(
            using = BooleanJsonSerializer.class
    )
    private Boolean isStarFriend;
    private String rowId;
}
