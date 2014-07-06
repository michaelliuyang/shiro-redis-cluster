package com.michaelliuyang.shiro.demo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by michael on 14-7-4.
 */
public class User {

    private Long id;
    private String name;
    private String password;
    private Set<Role> roleSet = new HashSet<Role>();
    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
