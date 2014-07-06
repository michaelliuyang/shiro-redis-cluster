package com.michaelliuyang.shiro.demo.model;

public class UserCredentials {

    private String password;

    private String salt;

    public UserCredentials(String password, String salt) {
        this.password = password;
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
