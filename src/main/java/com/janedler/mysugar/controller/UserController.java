package com.janedler.mysugar.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.janedler.mysugar.db.entity.TUser;
import com.janedler.mysugar.db.service.db1.TMenuChildService;
import com.janedler.mysugar.db.service.db1.TMenuService;
import com.janedler.mysugar.db.entity.TbUser;
import com.janedler.mysugar.db.service.db2.TbUserService;
import com.janedler.mysugar.domain.entity.AppUser;
import com.janedler.mysugar.domain.response.AppUserResp;
import com.janedler.mysugar.domain.response.PageIndexResp;
import com.janedler.mysugar.utils.RedisUtil;
import com.janedler.mysugar.utils.SecurityUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Value("${jwt.key}")
    private String jwtKey;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    TMenuService menuService;

    @Autowired
    TMenuChildService menuChildService;

    @Autowired
    TbUserService tbUserService;


    @GetMapping("/api/userInfo")
    @ResponseBody
    public TUser getUserMessage() {
        return SecurityUtil.getLoginUser();
    }


    @RequestMapping(value = "/api/userAppInfo/{currentPage}/{pageCount}", method = RequestMethod.GET)
    @ResponseBody
    public List<TbUser> getAppUserMessage(@PathVariable(value = "currentPage") int currentPage,@PathVariable(value = "pageCount") int pageCount) {
        logger.info("currentPage>>"+currentPage+" pageCount>>"+pageCount);



        return tbUserService.getTbUserList();


//        AppUserResp appUserResp = new AppUserResp();
//        appUserResp.resultCode = 0;
//        Page<TbUser> page = tbUserService.selectPage(new Page<TbUser>(currentPage,pageCount),new EntityWrapper<>());
//        if (page == null){
//            return appUserResp;
//        }
//        appUserResp.setTotalCount(page.getPages());
//
//
//
//        List<AppUser> users = new ArrayList<>();
//        for (int i = 0; i < page.getRecords().size(); i++) {
//            TbUser tbUser = page.getRecords().get(i);
//            AppUser appUser = new AppUser();
//            appUser.setKey(UUID.randomUUID().toString());
//            appUser.setUid(tbUser.getUid());
//            appUser.setNickname(tbUser.getNickname());
//            appUser.setRealName(tbUser.getRealName());
//            appUser.setPlatformaccount(tbUser.getPlatformAccount());
//            appUser.setPassword(tbUser.getPassword());
//            appUser.setRecommendId(tbUser.getRecommendId());
//            appUser.setSex(tbUser.getSex()==0?"女":"男");
//            appUser.setBirthday("1990-08-23");
//            appUser.setPhone(tbUser.getPhone());
//            appUser.setLocation(tbUser.getLocation());
//            appUser.setVip(tbUser.getVip());
//            appUser.setSignText(tbUser.getSignText());
//            appUser.setPoint(tbUser.getPoint());
//            List<String> photoUrls = new ArrayList<>();
//            photoUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
//            photoUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
//            photoUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
//            photoUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
//            appUser.setPhotoUrls(photoUrls);
//            appUser.setAvatarUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
//            users.add(appUser);
//        }
//        appUserResp.setUsers(users);
//        return appUserResp;
    }



    @RequestMapping(value = "/pageIndex", method = { RequestMethod.POST })
    @ResponseBody
    public PageIndexResp pageIndex() {

        /*PageIndexResp pageIndexResp = new PageIndexResp();

        List<MenuCategory> menuNavLists = new ArrayList<>();


        List<TMenu> menus = menuService.selectList(null);
        for (int i = 0; i < menus.size(); i++) {
            MenuCategory menuCategory = new MenuCategory();
            TMenu menu = menus.get(i);
            menuCategory.setMenuCategory(menu.getMenuName());
            menuCategory.setMenuIcon(menu.getMenuIcon());
            List<Menu> menuList = new ArrayList<>();
            List<TMenuChild> menuChilds = menuChildService.selectList(new Wrapper<TMenuChild>() {
                @Override
                public TMenuChild getEntity() {
                    TMenuChild tMenuChild = new TMenuChild();
                    tMenuChild.setMenuId(menu.getId());
                    return tMenuChild;
                }

                @Override
                public String getSqlSegment() {
                    return "menuId";
                }
            });
            for (int j = 0; j < menuChilds.size(); j++) {
                TMenuChild menuChild = menuChilds.get(j);
                Menu menuTmp = new Menu();
                menuTmp.menuName = menuChild.getMenuName();
                menuTmp.menuUrl = menuChild.getRoutUrl();
                menuList.add(menuTmp);
            }
            menuCategory.setMenus(menuList);
            menuNavLists.add(menuCategory);
        }
        pageIndexResp.resultCode = 0;
        pageIndexResp.message = "";
        pageIndexResp.setMenuNavLists(menuNavLists);*/
        return null;
    }

}
