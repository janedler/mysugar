/**
 *
 */
package com.janedler.mysugar.shiro.bean;


import com.janedler.mysugar.db.entity.TUser;

import java.io.Serializable;

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
     * jwt凭证
     */
    private String jwt;

    /**
     * 用户信息
     */
    private TUser user;

    public ShiroUser() {
    }

    public ShiroUser(long id,String jwt) {
        this.uId = id;
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

}