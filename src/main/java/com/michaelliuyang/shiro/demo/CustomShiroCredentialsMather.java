package com.michaelliuyang.shiro.demo;

import com.michaelliuyang.shiro.demo.model.UserCredentials;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * custom validate password
 *
 * @author michael
 */
public class CustomShiroCredentialsMather extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token,
                                      AuthenticationInfo info) {
        UsernamePasswordToken ut = (UsernamePasswordToken) token;
        UserCredentials userCredentials = (UserCredentials) getCredentials(info);
        String tokenPwd = PasswordUtil.encrytPwd(ut.getPassword(),
                userCredentials.getSalt());
        return equals(tokenPwd, userCredentials.getPassword());
    }

}
