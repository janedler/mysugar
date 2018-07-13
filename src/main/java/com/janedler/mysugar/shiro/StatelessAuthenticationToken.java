package com.janedler.mysugar.shiro;

/**
 * Created by betty77 on 2017/7/31.
 */

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 用于授权的Token对象：
 * 用户身份即用户名；
 * 凭证即客户端传入的消息摘要。
 */
public class StatelessAuthenticationToken implements AuthenticationToken {
    private static final long serialVersionUID = 1L;
    private long uid;
    private String macAddress;
    private boolean rememberMe;
    private String token;

    public StatelessAuthenticationToken(String macAddress,String token) {
        super();
        this.macAddress = macAddress;
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return uid;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
