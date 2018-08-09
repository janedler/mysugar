package com.janedler.mysugar.db.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * <p>
 * 用户身份认证表
 * </p>
 *
 * @author dgd123
 * @since 2018-08-09
 */
@Data
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
    private Date createTime;


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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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
