package com.janedler.mysugar.controller;

import com.janedler.mysugar.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "Redis")
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisUtil redisUtil;

    @ApiOperation(value = "保存数据", notes = "保存数据")
    @GetMapping("/api/setRedis")
    @ResponseBody
    public String setRedis() {
        redisUtil.set("Hello","Hello janedler");
        return "OK";
    }

    @ApiOperation(value = "获取数据", notes = "获取数据")
    @GetMapping("/api/getRedis")
    @ResponseBody
    public String getRedis() {
        return redisUtil.get("Hello").toString();
    }

}
