package com.aladdin.demo.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class SecurityHelper {

	private static final String KEY = "ALADDIN_DANGDANG++123";

	/**
	 * 加密，使用默认的KEY
	 * 
	 * @param content
	 * @return
	 */
	public static String encrypt(String content) {
		return encrypt(content, KEY);
	}

	/**
	 * 解密，使用默认的KEY
	 * 
	 * @param content
	 * @return
	 */
	public static String decrypt(String content) {
		return decrypt(content, KEY);
	}

	/**
	 * 加密
	 * 
	 * @param content
	 *            待加密内容
	 * @param key
	 *            加密的密钥
	 * @return
	 */
	public static String encrypt(String content, String key) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(key.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] byteRresult = cipher.doFinal(byteContent);
			return Base64.encodeBase64String(byteRresult);
		} catch (Exception e) {
			LogHome.getLog().error("", e);
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param key
	 *            解密的密钥
	 * @return
	 */
	public static String decrypt(String content, String key) {
		if (content.length() < 1){
			return null;
		}
		byte[] byteRresult = Base64.decodeBase64(content);
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(key.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] result = cipher.doFinal(byteRresult);
			return new String(result);
		} catch (Exception e) {
			LogHome.getLog().error("", e);
		}
		return null;
	}

	public static String getMD5(String plainText) {
	    try {
            if (StringUtils.isEmpty(plainText)) {
                return "";
            }
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(plainText.getBytes("utf-8"));
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            // 标准的md5加密后的结果
            return buffer.toString().toLowerCase();
        } catch (Exception e) {
            LogHome.getLog().error("md5加密异常", e);
            return "";
        }
	}

	public static void main(String[] args) {
		String content = "AEStest";
		System.out.println("密　钥：" + KEY);
		System.out.println("加密前：" + content);
		// 加密
		String encryptResult = encrypt(content, KEY);
		System.out.println("加密后：" + encryptResult);
		// 解密
		String decryptResult = decrypt(encryptResult, KEY);
		System.out.println("解密后：" + decryptResult);
	}

}
