package com.janedler.mysugar.controller;

import com.alibaba.fastjson.JSONObject;
import com.janedler.mysugar.domain.request.LoginReq;
import com.janedler.mysugar.domain.response.ResultResp;
import com.janedler.mysugar.entity.TUser;
import com.janedler.mysugar.exception.CommonException;
import com.janedler.mysugar.service.TUserService;
import com.janedler.mysugar.service.impl.TUserServiceImpl;
import com.janedler.mysugar.shiro.StatelessAuthenticationToken;
import com.janedler.mysugar.shiro.StatelessAuthorizingRealm;
import com.janedler.mysugar.shiro.bean.ResponseBean;
import com.janedler.mysugar.shiro.bean.ShiroUser;
import com.janedler.mysugar.utils.JsonWebTokenUtil;
import com.janedler.mysugar.utils.RedisUtil;
import com.janedler.mysugar.utils.SecurityUtil;
import com.janedler.mysugar.utils.ValidateUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.janedler.mysugar.shiro.StatelessAuthorizingRealm.REDIS_KEY;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Janedler
 * @since 2018-07-12
 */
@Controller
@RequestMapping("/tUser")
public class TUserController {

    private static final Logger logger = Logger.getLogger(StatelessAuthorizingRealm.class);

    @Autowired
    TUserService userService;

    @Value("${jwt.key}")
    private String jwtKey;

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/api/userInfo")
    @ResponseBody
    public TUser getUserMessage() {
        return SecurityUtil.getLoginUser();
    }

    @RequestMapping(value = "/api/register", method = { RequestMethod.POST })
    @ResponseBody
    public ResultResp userRegister(HttpServletRequest request, @Valid @RequestBody LoginReq loginReq) {
        String macAddress = request.getHeader("MacAddress");
        String userNameRep = loginReq.userName;
        String passwordRep = loginReq.password;
        String jwt = new JsonWebTokenUtil(jwtKey).getJWTString(userNameRep + passwordRep, 43200);
        logger.info("jwt>> " + jwt);
        if (userService.getUserByUserName(userNameRep) != null){
            throw new CommonException(600,"改用户已存在");
        }
        String password = SecurityUtil.decodePassword(passwordRep, jwtKey);
        logger.info("password>> " + password);
        TUser tUser = new TUser();
        tUser.setUsername(userNameRep);
        tUser.setPassword(password);
        tUser.setPermission("permission:costomUser");
        userService.insert(tUser);

        TUser dbUser = userService.getUserByUserName(userNameRep);
        ShiroUser shiroUser = new ShiroUser(dbUser.getId(), macAddress, jwt);
        shiroUser.setUser(dbUser);
        redisUtil.set(REDIS_KEY+"auth_info:"+jwt, JSONObject.toJSONString(shiroUser));
        ResultResp resultResp = new ResultResp();
        resultResp.resultCode = 200;
        resultResp.message = "注册成功";
        return resultResp;
    }



    @RequestMapping(value = "/api/login", method = { RequestMethod.POST })
    @ResponseBody
    public ShiroUser userLogin(HttpServletRequest request, @Valid @RequestBody LoginReq loginReq) {
        String macAddress = request.getHeader("MacAddress");
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
        logger.info("jwt>> " + jwt);
        ShiroUser shiroUser = new ShiroUser(dbUser.getId(), macAddress, jwt);
        shiroUser.setUser(dbUser);
        redisUtil.set(REDIS_KEY+"auth_info:"+jwt, JSONObject.toJSONString(shiroUser));
        return shiroUser;
    }

}
