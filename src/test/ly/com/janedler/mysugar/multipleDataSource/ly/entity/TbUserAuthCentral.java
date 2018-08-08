package com.janedler.mysugar.multipleDataSource.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("tb_user_auth_central")
public class TbUserAuthCentral extends Model<TbUserAuthCentral> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户
     */
    private Integer uid;
    /**
     * 手机0 ,实名认证1,支付认证2,微信认证3,技能认证4
     */
    private Integer authType;
    /**
     * 证件号(实名认证必填)
     */
    private String authNumber;
    /**
     * 证件类型
     */
    private Integer authCardType;
    /**
     * 正面图片
     */
    private String frontUrl;
    /**
     * 反面图片
     */
    private String behindUrl;
    /**
     * 技能 id
     */
    private Integer skillId;
    /**
     * 认证状态 1,审核中 2,审核完成
     */
    private Integer authStatus;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 最后修改时间
     */
    private LocalDateTime lastModTime;


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

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getAuthNumber() {
        return authNumber;
    }

    public void setAuthNumber(String authNumber) {
        this.authNumber = authNumber;
    }

    public Integer getAuthCardType() {
        return authCardType;
    }

    public void setAuthCardType(Integer authCardType) {
        this.authCardType = authCardType;
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

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
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

    public LocalDateTime getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(LocalDateTime lastModTime) {
        this.lastModTime = lastModTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbUserAuthCentral{" +
        "id=" + id +
        ", uid=" + uid +
        ", authType=" + authType +
        ", authNumber=" + authNumber +
        ", authCardType=" + authCardType +
        ", frontUrl=" + frontUrl +
        ", behindUrl=" + behindUrl +
        ", skillId=" + skillId +
        ", authStatus=" + authStatus +
        ", createTime=" + createTime +
        ", lastModTime=" + lastModTime +
        "}";
    }
}
