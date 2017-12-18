package com.zkx.bbs.service;

import com.zkx.bbs.common.BBSConstant;
import com.zkx.bbs.entity.User;
import com.zkx.bbs.entity.app.LoginInfo;
import com.zkx.bbs.entity.app.UserInfo;
import com.zkx.bbs.util.UserPassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 登录登出
 */
@Service
public class LoginService {
    @Autowired
    private UserService userService;

    public LoginInfo login(String account, String password, String platform, String appVersion) {
        User user = userService.queryUserByAccount(account);
        checkUser(user, password);

        String token = UserPassUtils.generateCookie(user, BBSConstant.Product.APP_DD);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId())
                .setPhone(user.getPhone())
                .setSex(user.getSex())
                .setSignature(user.getSignature())
                .setUserImage(user.getImage())
                .setUserName(user.getUserName());

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setToken(token)
                .setUserInfo(userInfo);
        return loginInfo;
    }

    public Map<String,Object> checkToken(String ddtoken) {
    }

    public void logout(String ddtoken, Long userId) {
    }
}
