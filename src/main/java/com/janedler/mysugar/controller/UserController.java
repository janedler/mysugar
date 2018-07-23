package com.janedler.mysugar.controller;

import com.alibaba.fastjson.JSONObject;
import com.janedler.mysugar.domain.entity.Menu;
import com.janedler.mysugar.domain.request.LoginReq;
import com.janedler.mysugar.domain.response.PageIndexResp;
import com.janedler.mysugar.domain.response.ResultResp;
import com.janedler.mysugar.entity.TUser;
import com.janedler.mysugar.exception.CommonException;
import com.janedler.mysugar.service.TUserService;
import com.janedler.mysugar.shiro.StatelessAuthorizingRealm;
import com.janedler.mysugar.shiro.bean.ShiroUser;
import com.janedler.mysugar.utils.JsonWebTokenUtil;
import com.janedler.mysugar.utils.RedisUtil;
import com.janedler.mysugar.utils.SecurityUtil;
import com.janedler.mysugar.utils.ValidateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.janedler.mysugar.shiro.StatelessAuthorizingRealm.REDIS_KEY;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Value("${jwt.key}")
    private String jwtKey;

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/api/userInfo")
    @ResponseBody
    public TUser getUserMessage() {
        return SecurityUtil.getLoginUser();
    }

    @RequestMapping(value = "/pageIndex", method = { RequestMethod.POST })
    @ResponseBody
    public PageIndexResp pageIndex() {

        PageIndexResp pageIndexResp = new PageIndexResp();
        Map<String,List<Menu>> menuMap = new HashMap<>();

        //用户管理
        List<Menu> userMenuList = new ArrayList<>();
        Menu userMenu = new Menu();
        userMenu.menuName = "用户管理";
        userMenu.menuUrl = "UserContentPage";
        userMenuList.add(userMenu);
        menuMap.put("用户管理",userMenuList);

        //审核资格
        List<Menu> verifyList = new ArrayList<>();
        //身份审核
        Menu idCardMenu = new Menu();
        idCardMenu.menuName = "身份审核";
        idCardMenu.menuUrl = "IdCardContentPage";
        verifyList.add(idCardMenu);
        //朋友圈审核
        Menu circleFriendMenu = new Menu();
        circleFriendMenu.menuName = "朋友圈审核";
        circleFriendMenu.menuUrl = "CircleFriendContentPage";
        verifyList.add(circleFriendMenu);
        menuMap.put("审核资格",verifyList);
        pageIndexResp.menuMap = menuMap;
        return pageIndexResp;
    }

}
