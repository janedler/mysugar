package com.janedler.mysugar.utils;

import com.janedler.mysugar.shiro.bean.ShiroUser;
import com.janedler.mysugar.entity.TUser;
import org.apache.shiro.subject.Subject;

/**
 * Created by xushilong on 2018/1/17.
 */
public class SecurityUtil {

    public static TUser getLoginUser() {
        return getShiroUser().getUser();
    }

    public static ShiroUser getShiroUser() {
        Subject subject = getSubject();
        ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();

        return shiroUser;
    }


    public static String getUserId() {
        Subject subject = getSubject();
        ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
        if (!ValidateUtil.isNullOrEmpty(shiroUser.getUser())) {
            return shiroUser.getUser().getId()+"";
        }
        return null;
    }

    public static Subject getSubject() {
        return org.apache.shiro.SecurityUtils.getSubject();
    }

    public static String decodePassword(String password, String key) {
        return Base64Util.getFromBase64(XORUtil.getInstance().decode(password, key));
    }
}
