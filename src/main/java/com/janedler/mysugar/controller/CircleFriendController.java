package com.janedler.mysugar.controller;

import com.janedler.mysugar.domain.entity.CircleFriend;
import com.janedler.mysugar.domain.entity.UserRealNameAuth;
import com.janedler.mysugar.domain.response.CircleFriendResp;
import com.janedler.mysugar.domain.response.UserRealNameAuthResp;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/circleFriend")
public class CircleFriendController {

    private static final Logger logger = Logger.getLogger(CircleFriendController.class);

    @RequestMapping(value = "/list/{currentPage}/{pageCount}", method = { RequestMethod.GET})
    @ResponseBody
    public CircleFriendResp circleFriendList(@PathVariable(value = "currentPage") long currentPage, @PathVariable(value = "pageCount") int pageCount) {
        CircleFriendResp circleFriendResp = new CircleFriendResp();
        circleFriendResp.resultCode = 0;
        circleFriendResp.totalCount=100;
        List<CircleFriend> lists = new ArrayList<>();
        for (int i = 0; i < pageCount; i++) {
            CircleFriend circleFriend = new CircleFriend();
            circleFriend.id = i;
            circleFriend.idType = new Random().nextInt(3)+1;
            circleFriend.content="Hello World";
            List<String> picUrls = new ArrayList<>();
            picUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            picUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            picUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            picUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            picUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            picUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533213711267&di=fbf637238b353525e84ed914f47a2a4d&imgtype=0&src=http%3A%2F%2Fent.news.cn%2F2015-11%2F18%2F128440069_14478029181551n.jpg");
            circleFriend.picUrls=picUrls;
            circleFriend.time="2018 09-11";
            lists.add(circleFriend);
        }
        circleFriendResp.lists = lists;
        return circleFriendResp;
    }
}
