package com.janedler.mysugar.controller;


import com.alibaba.fastjson.JSONObject;
import com.janedler.mysugar.domain.request.LoginReq;
import com.janedler.mysugar.domain.response.LoginResp;
import com.janedler.mysugar.domain.response.ResultResp;
import com.janedler.mysugar.entity.TUser;
import com.janedler.mysugar.exception.CommonException;
import com.janedler.mysugar.service.TUserService;
import com.janedler.mysugar.shiro.bean.ShiroUser;
import com.janedler.mysugar.utils.JsonWebTokenUtil;
import com.janedler.mysugar.utils.RedisUtil;
import com.janedler.mysugar.utils.SecurityUtil;
import com.janedler.mysugar.utils.ValidateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.janedler.mysugar.shiro.StatelessAuthorizingRealm.REDIS_KEY;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = Logger.getLogger(AuthController.class);

    @Autowired
    TUserService userService;

    @Value("${jwt.key}")
    private String jwtKey;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/login", method = { RequestMethod.POST })
    @ResponseBody
    public LoginResp login(@Valid @RequestBody LoginReq loginReq) {
        String userNameRep = loginReq.userName;
        String passwordRep = loginReq.password;
        if (ValidateUtil.isNullOrEmpty(userNameRep) || ValidateUtil.isNullOrEmpty(passwordRep)) {
            throw new CommonException(600, "用户名或者密码为空");
        }
        String password = SecurityUtil.decodePassword(passwordRep, jwtKey);
        TUser dbUser = userService.getUserByUserNameAndPassword(userNameRep,password);
        if (dbUser == null){
            throw new CommonException(601, "该用户不存在");
        }
        String jwt = new JsonWebTokenUtil(jwtKey).getJWTString(userNameRep + passwordRep, 43200);
        ShiroUser shiroUser = new ShiroUser(dbUser.getId(), jwt);
        shiroUser.setUser(dbUser);
        redisUtil.set(REDIS_KEY+"auth_info:"+jwt, JSONObject.toJSONString(shiroUser));
        LoginResp loginResp = new LoginResp();
        loginResp.resultCode = 0;
        loginResp.message="登录成功";
        loginResp.setUid(shiroUser.getuId()+"");
        loginResp.setUsername(shiroUser.getUser().getUsername());
        loginResp.setToken(jwt);
        logger.info(loginResp.toString());
        return loginResp;
    }


}
