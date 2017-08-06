package com.zkx.bbs.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zkx.bbs.entity.Token;
import com.zkx.bbs.entity.User;

import java.util.Random;

public class UserPassUtils {

    private static final String KEY = "dangdang_qazwsxedc";

    /**
     * 加密
     * 
     * @param content
     * @return
     */
    public static String encrypt(String content) {
        return SecurityHelper.encrypt(content, KEY);
    }

    /**
     * 解密
     * 
     * @param content
     * @return
     */
    public static String decrypt(String content) {
        return SecurityHelper.decrypt(content, KEY);
    }

    /**
     * 生成用户token
     * 
     * @param user
     * @param product
     * @return
     */
    public static String generateCookie(User user, int product) {
        Token token = new Token();
        token.setUserId(user.getUserId());
        token.setUserPhone(user.getPhone());
        token.setProduct(product);
        Random random = new Random();
        token.setRand(System.currentTimeMillis() + random.nextInt(100000));
        return encryptToken(token);
    }

    public static void main(String[] args) {
        Token token = new Token();
        token.setUserId(200098L);
        token.setUserPhone("15801396285");
        token.setProduct(1);
        Random random = new Random();
        token.setRand(System.currentTimeMillis() + random.nextInt(100000));
        String ss = JSONObject.toJSONString(token);
        System.out.println(ss.length());
        System.out.println(ss);
        String s = encryptToken(token);
        System.out.println(s);

        Token tokens = decryptToken(s);
        System.out.println(tokens);

    }

    /**
     * 加密
     * 
     * @param token
     * @return
     */
    public static String encryptToken(Token token) {
        try {
            return SecurityHelper.encrypt(JSONObject.toJSONString(token), KEY);
            // String baseStr =
            // Base64.encodeBase64String(JSONObject.toJSONString(token).getBytes());
            // StringBuilder stringBuilder = new StringBuilder(baseStr);
            // String reverseStr = stringBuilder.reverse().toString();
            // return reverseStr;
        } catch (Exception e) {
            LogHome.getLog().error("加密异常", e);
            return null;
        }
    }

    /**
     * 解密
     * 
     * @param token
     * @return
     */
    public static Token decryptToken(String token) {
        try {
            String decrypt = SecurityHelper.decrypt(token, KEY);
            return JSON.parseObject(decrypt, Token.class);
            // StringBuilder stringBuilder = new StringBuilder(token);
            // String reverseStr = stringBuilder.reverse().toString();
            //
            // byte[] decodeArray = Base64.decodeBase64(reverseStr);
            // String string = new String(decodeArray);
            //
            // return JSON.parseObject(string, Token.class);
        } catch (Exception e) {
            LogHome.getLog().error("解密异常", e);
            return null;
        }
    }

}
