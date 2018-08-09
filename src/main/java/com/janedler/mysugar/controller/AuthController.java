package com.janedler.mysugar.controller;


import com.alibaba.fastjson.JSONObject;
import com.janedler.mysugar.db.entity.TUser;
import com.janedler.mysugar.db.service.db1.TUserService;
import com.janedler.mysugar.domain.entity.UserRealNameAuth;
import com.janedler.mysugar.domain.request.LoginReq;
import com.janedler.mysugar.domain.response.LoginResp;
import com.janedler.mysugar.domain.response.ResultResp;
import com.janedler.mysugar.domain.response.UserRealNameAuthResp;
import com.janedler.mysugar.exception.CommonException;
import com.janedler.mysugar.shiro.bean.ShiroUser;
import com.janedler.mysugar.utils.JsonWebTokenUtil;
import com.janedler.mysugar.utils.RedisUtil;
import com.janedler.mysugar.utils.SecurityUtil;
import com.janedler.mysugar.utils.ValidateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

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
        loginResp.setUsername(shiroUser.getUser().getUserName());
        loginResp.setToken(jwt);
        logger.info(loginResp.toString());
        return loginResp;
    }





    @RequestMapping(value = "/realNameAuth/{currentPage}/{pageCount}", method = { RequestMethod.GET})
    @ResponseBody
    public UserRealNameAuthResp realNameAuth(@PathVariable(value = "currentPage") long currentPage, @PathVariable(value = "pageCount") int pageCount) {
        UserRealNameAuthResp userRealNameAuthResp = new UserRealNameAuthResp();
        userRealNameAuthResp.resultCode = 0;
        userRealNameAuthResp.totalCount=100;
        List<UserRealNameAuth> lists = new ArrayList<>();
        for (int i = 0; i < pageCount; i++) {
            UserRealNameAuth userRealNameAuth = new UserRealNameAuth();
            userRealNameAuth.id = i;
            userRealNameAuth.uid = 123;
            userRealNameAuth.idCardType = 0;
            userRealNameAuth.idCardNumber = "123123214214";
            userRealNameAuth.realName = "Hello";
            userRealNameAuth.frontUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg";
            userRealNameAuth.behindUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg";
            userRealNameAuth.authStatus = 0;
            userRealNameAuth.createTime = "2018 9-10";
            lists.add(userRealNameAuth);
        }
        userRealNameAuthResp.lists = lists;
        return userRealNameAuthResp;
    }


    @RequestMapping(value = "/realNameAuth/{id}/{authStatus}", method = RequestMethod.POST)
    @ResponseBody
    public ResultResp yuxin(@PathVariable(value = "id") long id,@PathVariable(value = "authStatus") int authStatus){
        logger.info("id:"+id+" authStatus:"+authStatus);
        ResultResp resultResp = new ResultResp();
        resultResp.resultCode = 0;
        resultResp.message="审核操作成功";
        return resultResp;
    }

}
