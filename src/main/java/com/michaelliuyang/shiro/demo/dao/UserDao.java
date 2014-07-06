package com.michaelliuyang.shiro.demo.dao;

import com.michaelliuyang.shiro.demo.model.Permission;
import com.michaelliuyang.shiro.demo.model.Role;
import com.michaelliuyang.shiro.demo.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by michael on 14-7-5.
 */
public class UserDao {

    public User findByName(String name) {
        //mock user
        User user = new User();
        user.setId(1l);
        user.setName("michael");
        user.setPassword("phN4savQMoWQ+uPP35GjOg==");//000000
        user.setSalt("123");
        Set<Role> roleSet = new HashSet<Role>();
        Role role = new Role(1l, "admin");
        role.setPermissionList(Permission.getValueList());
        roleSet.add(role);
        user.setRoleSet(roleSet);
        return user;
    }

}
