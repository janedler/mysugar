package com.janedler.mysugar.controller;

import com.janedler.mysugar.entity.TUser;
import com.janedler.mysugar.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;

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

    @RequestMapping(value = "/api/insertUser/{permission}", method = RequestMethod.GET)
    @ResponseBody
    public TUser insertUser(@PathVariable String permission) throws Exception {
        /*Base64.Decoder decoder = Base64.getDecoder();
        Base64.Encoder encoder = Base64.getEncoder();
        String text = permission;
        byte[] textByte = text.getBytes("UTF-8");
        String encodedText = encoder.encodeToString(textByte);
        TUser user = new TUser();
        user.setPermission(encodedText);
        user.setUsername("lijian");
        user.setPassword("123");
        userService.insert(user);
        TUser userTmp = userService.selectList(null).get(0);
        TUser resultUser = new TUser();
        resultUser.setPassword(userTmp.getPassword());
        resultUser.setId(userTmp.getId());
        resultUser.setUsername(userTmp.getUsername());
        resultUser.setPermission(new String(decoder.decode(userTmp.getPermission()), "UTF-8"));
        return resultUser;*/
        TUser user = new TUser();
        user.setPermission(permission);
        user.setUsername("lijian");
        user.setPassword("123");
        userService.insert(user);
        return userService.selectList(null).get(0);
    }

}
