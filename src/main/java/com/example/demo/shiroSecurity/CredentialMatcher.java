package com.example.demo.shiroSecurity;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;


//自定义密码比较器
public class CredentialMatcher extends SimpleCredentialsMatcher {

    // token是用户请求的，info是数据库存储的
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = String.valueOf(usernamePasswordToken.getPassword());
        String dbPassword = (String)info.getCredentials();
        return this.equals(password,dbPassword);
    }
}
