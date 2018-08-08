package com.janedler.mysugar.domain.response;

import com.janedler.mysugar.domain.entity.AppUser;

import java.util.List;

public class AppUserResp extends ResultResp{

    private long totalCount;

    private long currentPage;

    private List<AppUser> users;

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }


}
