package com.janedler.mysugar.db.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author dgd123
 * @since 2018-08-09
 */
@Data
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
