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
@TableName("t_menu_child")
public class TMenuChild extends Model<TMenuChild> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer menuId;
    private String menuName;
    private String routUrl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getRoutUrl() {
        return routUrl;
    }

    public void setRoutUrl(String routUrl) {
        this.routUrl = routUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TMenuChild{" +
        "id=" + id +
        ", menuId=" + menuId +
        ", menuName=" + menuName +
        ", routUrl=" + routUrl +
        "}";
    }
}
