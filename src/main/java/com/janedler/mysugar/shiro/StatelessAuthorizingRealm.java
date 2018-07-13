package com.janedler.mysugar.shiro;


import com.alibaba.fastjson.JSONObject;
import com.janedler.mysugar.shiro.bean.Role;
import com.janedler.mysugar.shiro.bean.ShiroUser;
import com.janedler.mysugar.entity.TUser;
import com.janedler.mysugar.service.TUserService;
import com.janedler.mysugar.utils.*;
import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

public class StatelessAuthorizingRealm extends AuthorizingRealm {

    public static final String REDIS_KEY = "shiro:";

    private static final Logger logger = Logger.getLogger(StatelessAuthorizingRealm.class);

    @Autowired
    TUserService userService;

    @Autowired
    RedisUtil redisUtil;

    @Value("${jwt.key}")
    private String jwtKey;

    /**
     * 给ShiroDbRealm提供编码信息，用于密码密码比对
     * 描述
     */
    public StatelessAuthorizingRealm() {
        super();
    }

    /**
     * 仅支持StatelessToken 类型的Token，
     * 那么如果在StatelessAuthcFilter类中返回的是UsernamePasswordToken，那么将会报如下错误信息：
     * Please ensure that the appropriate Realm implementation is configured correctly or
     * that the realm accepts AuthenticationTokens of this type.StatelessAuthcFilter.isAccessAllowed()
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof StatelessAuthenticationToken;
    }

    /**
     * 身份验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        logger.info("doGetAuthenticationInfo");

        StatelessAuthenticationToken statelessToken = (StatelessAuthenticationToken) token;
        String jwt = statelessToken.getToken();
        Claims claims = new JsonWebTokenUtil(jwtKey).parseJWT(jwt);
        if (claims == null || claims.getExpiration().before(new Date())) {
            redisUtil.del(REDIS_KEY+"auth_info:"+jwt);
            redisUtil.del(REDIS_KEY+"auth_permission:"+jwt);
            throw new AuthorizationException("login overtime");
        }
        ShiroUser shiroUser = getAuthInfo(jwt);
        if (!ValidateUtil.isNullOrEmpty(shiroUser)) {
            if (!statelessToken.getMacAddress().equals(shiroUser.getMacAddress())){
                redisUtil.del(REDIS_KEY+"auth_info:"+jwt);
                redisUtil.del(REDIS_KEY+"auth_permission:"+jwt);
                throw new AuthorizationException("login overtime");
            }
            return new SimpleAuthenticationInfo(getAuthInfo(jwt), jwt, getName());
        }
        TUser user = userService.selectById(statelessToken.getUid());
        if (!ValidateUtil.isNullOrEmpty(user)) {
            ShiroUser shiroUserTmp = new ShiroUser(user.getId(), user.getUsername(), jwt);
            shiroUserTmp.setUser(user);
            setAuthInfo(shiroUserTmp, jwt);
            // 这里可以缓存认证
            return new SimpleAuthenticationInfo(shiroUserTmp, jwt, getName());
        } else {
            throw new AuthorizationException("login fail");
        }
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
        SimpleAuthorizationInfo info = getAuthPermission(shiroUser.getJwt());
        if (ValidateUtil.isNullOrEmpty(info)) {
            info = newAuthorizationInfo(shiroUser);
            setAuthPermission(info, shiroUser.getJwt());
        }
        return info;
    }

    private SimpleAuthorizationInfo newAuthorizationInfo(ShiroUser shiroUser) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Collection<Role> roles = new HashSet<>();
//        roles.addAll(userService.getRolesByUserId(shiroUser.getId()));
        info.setRoles(makeRoles(roles, shiroUser));
        info.setStringPermissions(makePermissions(roles, shiroUser));
        return info;
    }

    /**
     * 组装角色权限
     *
     * @param roles
     * @param shiroUser
     * @return
     */
    private Set<String> makeRoles(Collection<Role> roles, ShiroUser shiroUser) {
        Set<String> hasRoles = new HashSet<>();
        for (Role role : roles) {
            hasRoles.add(role.getRoleName());
        }
        return hasRoles;
    }

    /**
     * 组装资源操作权限
     *
     * @param roles
     * @param shiroUser
     * @return
     */
    private Set<String> makePermissions(Collection<Role> roles, ShiroUser shiroUser) {
        Set<String> stringPermissions = new HashSet<>();
        for (Role role : roles) {
            /*List<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                String moduleSign = permission.getModule().getSign();
                String permissionSign = permission.getSign();
                stringPermissions.add(moduleSign + ":" + permissionSign);
            }*/
        }
        return stringPermissions;
    }

    private ShiroUser getAuthInfo(String jwt) {
        return JSONObject.parseObject((String) redisUtil.get(REDIS_KEY+"auth_info:"+jwt),ShiroUser.class);
    }


    private void setAuthInfo(ShiroUser shiroUser, String jwt) {
        redisUtil.set(REDIS_KEY+"auth_info:"+jwt,JSONObject.toJSONString(shiroUser));
    }


    private void setAuthPermission(SimpleAuthorizationInfo info, String jwt) {
        redisUtil.set(REDIS_KEY+"auth_permission:"+jwt,JSONObject.toJSONString(info));
    }

    private SimpleAuthorizationInfo getAuthPermission(String jwt) {
        return JSONObject.parseObject((String) redisUtil.get(REDIS_KEY+"auth_permission:"+jwt),SimpleAuthorizationInfo.class);
    }

}