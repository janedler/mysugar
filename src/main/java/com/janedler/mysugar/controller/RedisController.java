package com.janedler.mysugar.controller;

import com.janedler.mysugar.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisUtil redisUtil;


    @GetMapping("/api/setRedis")
    @ResponseBody
    public String setRedis() {
        redisUtil.set("Hello","Hello janedler");
        return "OK";
    }

    @GetMapping("/api/getRedis")
    @ResponseBody
    public String getRedis() {
        return redisUtil.get("Hello").toString();
    }

}
