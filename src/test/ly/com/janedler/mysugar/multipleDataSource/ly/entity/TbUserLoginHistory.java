package com.janedler.mysugar.multipleDataSource.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("tb_user_login_history")
public class TbUserLoginHistory extends Model<TbUserLoginHistory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * ip地址
     */
    @TableField("ip_address")
    private String ipAddress;
    /**
     * 登录地址
     */
    private String location;
    /**
     * 登录手机类型
     */
    @TableField("client_type")
    private String clientType;
    /**
     * 登录手机唯一识别码
     */
    @TableField("client_key")
    private String clientKey;
    /**
     * 登录时间戳存储utc格式
     */
    @TableField("login_timestamp")
    private LocalDateTime loginTimestamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public LocalDateTime getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(LocalDateTime loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbUserLoginHistory{" +
        "id=" + id +
        ", uid=" + uid +
        ", ipAddress=" + ipAddress +
        ", location=" + location +
        ", clientType=" + clientType +
        ", clientKey=" + clientKey +
        ", loginTimestamp=" + loginTimestamp +
        "}";
    }
}
