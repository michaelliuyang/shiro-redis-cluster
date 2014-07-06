package com.michaelliuyang.shiro.demo;

import org.apache.shiro.crypto.hash.Md5Hash;

public class PasswordUtil {

    private PasswordUtil() {
    }

    public static String encrytPwd(char[] password, String salt) {
        Md5Hash md5Hash = new Md5Hash(password, salt);
        return md5Hash.toBase64();
    }

}
