package com.janedler.mysugar.domain.response;

public class LoginResp extends ResultResp{

    private String uid;
    private String username;
    private String token;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResp{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", resultCode=" + resultCode +
                ", message='" + message + '\'' +
                '}';
    }
}
