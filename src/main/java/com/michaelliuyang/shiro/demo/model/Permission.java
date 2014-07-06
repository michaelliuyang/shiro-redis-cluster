package com.michaelliuyang.shiro.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author michael
 */
public enum Permission {

    USER_DEFAULT("user:default", "默认"),

    USER_MAINTAIN("user:maintain", "用户管理");

    private static Map<String, Permission> valueMap = new HashMap<String, Permission>();

    public String value;
    public String displayName;

    static {
        for (Permission permission : Permission.values()) {
            valueMap.put(permission.value, permission);
        }
    }

    Permission(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static Permission parse(String value) {
        return valueMap.get(value);
    }

    public static List<String> getValueList() {
        List<String> valueList = new ArrayList<String>();
        for (Permission permission : Permission.values()) {
            valueList.add(permission.getValue());
        }
        return valueList;
    }

    public String getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }
}
