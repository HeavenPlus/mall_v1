package com.heaven.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/7 下午10:08
 */
public class MD5Utils {
    /**
     *
     * @Title: MD5Utils.java
     * @Package com.imooc.utils
     * @Description: 对字符串进行md5加密
     */
    public static String getMD5Str(String strValue) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest(strValue.getBytes()));
    }
}
