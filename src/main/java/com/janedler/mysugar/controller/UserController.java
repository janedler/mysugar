package com.janedler.mysugar.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.janedler.mysugar.domain.entity.AppUser;
import com.janedler.mysugar.domain.entity.Menu;
import com.janedler.mysugar.domain.entity.MenuCategory;
import com.janedler.mysugar.domain.request.LoginReq;
import com.janedler.mysugar.domain.response.AppUserResp;
import com.janedler.mysugar.domain.response.PageIndexResp;
import com.janedler.mysugar.domain.response.ResultResp;
import com.janedler.mysugar.entity.TMenu;
import com.janedler.mysugar.entity.TMenuChild;
import com.janedler.mysugar.entity.TUser;
import com.janedler.mysugar.exception.CommonException;
import com.janedler.mysugar.service.TMenuChildService;
import com.janedler.mysugar.service.TMenuService;
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

import java.util.*;

import static com.janedler.mysugar.shiro.StatelessAuthorizingRealm.REDIS_KEY;

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


    @GetMapping("/api/userInfo")
    @ResponseBody
    public TUser getUserMessage() {
        return SecurityUtil.getLoginUser();
    }


    @RequestMapping(value = "/api/userAppInfo/{currentPage}/{pageCount}", method = RequestMethod.GET)
    @ResponseBody
    public AppUserResp getAppUserMessage(@PathVariable(value = "currentPage") long currentPage,@PathVariable(value = "pageCount") int pageCount) {


        logger.info("currentPage>>"+currentPage+" pageCount>>"+pageCount);

        AppUserResp appUserResp = new AppUserResp();
        appUserResp.resultCode = 0;
        appUserResp.setTotalCount(100);
        appUserResp.setCurrentPage(currentPage);
        List<AppUser> users = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            AppUser appUser = new AppUser();
            appUser.setKey(UUID.randomUUID().toString());
            appUser.setUid(i);
            appUser.setNickname("Hello_"+i);
            appUser.setRealName("World_"+i);
            appUser.setPlatformaccount("ly1111_"+1);
            appUser.setPassword("123456");
            appUser.setRecommendId(111111);
            appUser.setSex("男");
            appUser.setBirthday("1990-08-23");
            appUser.setPhone("1234567890");
            appUser.setLocation("上海浦东");
            appUser.setVip(3);
            appUser.setSignText("Hello World");
            appUser.setPoint(30);
            List<String> photoUrls = new ArrayList<>();
            photoUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            photoUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            photoUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            photoUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            appUser.setPhotoUrls(photoUrls);
            appUser.setAvatarUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            users.add(appUser);
        }
        appUserResp.setUsers(users);
        return appUserResp;
    }



    @RequestMapping(value = "/pageIndex", method = { RequestMethod.POST })
    @ResponseBody
    public PageIndexResp pageIndex() {

        PageIndexResp pageIndexResp = new PageIndexResp();

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
        pageIndexResp.setMenuNavLists(menuNavLists);
        return pageIndexResp;
    }

}
