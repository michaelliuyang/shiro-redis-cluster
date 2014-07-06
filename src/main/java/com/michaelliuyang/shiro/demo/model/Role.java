package com.michaelliuyang.shiro.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 14-7-5.
 */
public class Role {

    private Long id;
    private String name;

    private List<String> permissionList = new ArrayList<String>();

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<String> permissionList) {
        this.permissionList = permissionList;
    }
}
