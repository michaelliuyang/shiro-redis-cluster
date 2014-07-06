package com.michaelliuyang.shiro.demo;

import com.michaelliuyang.shiro.demo.dao.UserDao;
import com.michaelliuyang.shiro.demo.model.Role;
import com.michaelliuyang.shiro.demo.model.User;
import com.michaelliuyang.shiro.demo.model.UserCredentials;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.io.Serializable;

/**
 * custom authentication and authorizationInfo
 *
 * @author michael
 */
public class ShiroDbRealm extends AuthorizingRealm {

    private UserDao userDao;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        System.out.println("Input user name:" + token.getUsername());
        User user = getUserDao().findByName(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(
                    new ShiroUser(user.getId(), user.getName()),
                    new UserCredentials(user.getPassword(), user.getSalt()),
                    getName());
        } else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName())
                .iterator().next();
        System.out.println("shiro user name:" + shiroUser.getName());
        User user = getUserDao().findByName(shiroUser.getName());
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for (Role role : user.getRoleSet()) {
                info.addStringPermissions(role.getPermissionList());
                info.addRole(role.getName());
            }
            return info;
        } else {
            return null;
        }
    }

    /**
     * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
     */
    public static class ShiroUser implements Serializable {

        private static final long serialVersionUID = -1748602382963711884L;
        private Long id;
        private String name;

        public ShiroUser(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        /**
         * 本函数输出将作为默认的<shiro:principal/>输出.
         */
        @Override
        public String toString() {
            return this.name;
        }
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
