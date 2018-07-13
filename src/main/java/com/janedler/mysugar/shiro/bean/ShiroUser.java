/**
 *
 */
package com.janedler.mysugar.shiro.bean;

import com.janedler.mysugar.entity.TUser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1748602382963711884L;
    /**
     * 用户id
     */
    private long uId;

    /**
     * mac地址
     */
    private String macAddress;

    /**
     * jwt凭证
     */
    private String jwt;

    /**
     * 用户信息
     */
    private TUser user;

    public ShiroUser() {
    }

    public ShiroUser(long id, String macAddress, String jwt) {
        this.uId = id;
        this.macAddress = macAddress;
        this.jwt = jwt;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}