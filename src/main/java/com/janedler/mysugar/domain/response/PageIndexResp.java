package com.janedler.mysugar.domain.response;

import com.janedler.mysugar.domain.entity.Menu;
import com.janedler.mysugar.domain.entity.MenuCategory;

import java.util.List;
import java.util.Map;

public class PageIndexResp extends ResultResp{

    private List<MenuCategory> menuNavLists;

    public List<MenuCategory> getMenuNavLists() {
        return menuNavLists;
    }

    public void setMenuNavLists(List<MenuCategory> menuNavLists) {
        this.menuNavLists = menuNavLists;
    }
}
