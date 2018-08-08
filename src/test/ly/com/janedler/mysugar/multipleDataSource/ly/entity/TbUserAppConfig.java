package com.janedler.mysugar.multipleDataSource.ly.entity;

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
@TableName("tb_user_app_config")
public class TbUserAppConfig extends Model<TbUserAppConfig> {

    private static final long serialVersionUID = 1L;

    private Integer uid;
    /**
     * iOS, Andriod, ...
     */
    private String client;
    /**
     * 客户端唯一key
     */
    @TableField("client_key")
    private String clientKey;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "TbUserAppConfig{" +
        "uid=" + uid +
        ", client=" + client +
        ", clientKey=" + clientKey +
        "}";
    }
}
