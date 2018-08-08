package com.janedler.mysugar.multipleDataSource.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户身份认证表
 * </p>
 *
 * @author Janedler
 * @since 2018-08-08
 */
@TableName("tb_user_id_card")
public class TbUserIdCard extends Model<TbUserIdCard> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer idCardType;
    private String idCardNumber;
    private String realName;
    private String frontUrl;
    private String behindUrl;
    private Integer authStatus;
    private LocalDateTime createTime;


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

    public Integer getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(Integer idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl;
    }

    public String getBehindUrl() {
        return behindUrl;
    }

    public void setBehindUrl(String behindUrl) {
        this.behindUrl = behindUrl;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbUserIdCard{" +
        "id=" + id +
        ", uid=" + uid +
        ", idCardType=" + idCardType +
        ", idCardNumber=" + idCardNumber +
        ", realName=" + realName +
        ", frontUrl=" + frontUrl +
        ", behindUrl=" + behindUrl +
        ", authStatus=" + authStatus +
        ", createTime=" + createTime +
        "}";
    }
}
