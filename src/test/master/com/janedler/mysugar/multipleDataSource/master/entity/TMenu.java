package com.janedler.mysugar.multipleDataSource.master.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Janedler
 * @since 2018-08-08
 */
@TableName("t_menu")
public class TMenu extends Model<TMenu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String menuName;
    private String menuIcon;
    private String routUrl;
    private String permisson;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getRoutUrl() {
        return routUrl;
    }

    public void setRoutUrl(String routUrl) {
        this.routUrl = routUrl;
    }

    public String getPermisson() {
        return permisson;
    }

    public void setPermisson(String permisson) {
        this.permisson = permisson;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TMenu{" +
        "id=" + id +
        ", menuName=" + menuName +
        ", menuIcon=" + menuIcon +
        ", routUrl=" + routUrl +
        ", permisson=" + permisson +
        "}";
    }
}
