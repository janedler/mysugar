package com.janedler.mysugar.domain.response;

import com.janedler.mysugar.domain.entity.CircleFriend;
import com.janedler.mysugar.domain.entity.UserRealNameAuth;

import java.util.List;

public class CircleFriendResp extends ResultResp{

    public long totalCount;

    public List<CircleFriend> lists;

}
