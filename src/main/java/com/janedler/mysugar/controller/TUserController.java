package com.janedler.mysugar.controller;

import com.janedler.mysugar.entity.TUser;
import com.janedler.mysugar.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @Autowired
    TUserService userService;

    @GetMapping("/api/findAllUser")
    @ResponseBody
    public List<TUser> findAllUser() {
        return userService.selectList(null);
    }

    @GetMapping("/api/insertUser")
    @ResponseBody
    public String insertUser() {
        TUser user = new TUser();
        user.setName("Hello");
        user.setSex("男");
        user.setAddress("浦东新区");
        userService.insert(user);
        return "OK";
    }

}
