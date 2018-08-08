package com.janedler.mysugar.multipleDataSource.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
@TableName("tb_user")
public class TbUser extends Model<TbUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;
    /**
     * 推荐人账号
     */
    @TableField("recommend_id")
    private Integer recommendId;
    /**
     * 陪陪号
     */
    private String platformAccount;
    /**
     * 云信id
     */
    @TableField("yx_token")
    private String yxToken;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    @TableField("avatar_url")
    private String avatarUrl;
    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;
    /**
     * 性别(true 男, false 女)
     */
    private Boolean sex;
    /**
     * 生日
     */
    private LocalDate birthday;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 加密后密码
     */
    private String password;
    /**
     * 地址
     */
    private String location;
    /**
     * vip等级:0不是vip，其他表示等级
     */
    private Integer vip;
    /**
     * 签名
     */
    @TableField("sign_text")
    private String signText;
    /**
     * 禁用用户开关
     */
    private Boolean enabled;
    /**
     * 用户状态，0:新用户 1:NoPwdUser 2:NoInfoUser 3:完整用户
     */
    private Integer status;
    /**
     * 积分
     */
    private Integer point;
    /**
     * 用户照片组
     */
    @TableField("photo_urls")
    private String photoUrls;
    /**
     * 创建日期
     */
    @TableField("create_time")
    private LocalDateTime createTime;
    /**
     * 最后修改日期
     */
    @TableField("last_updated")
    private LocalDateTime lastUpdated;
    @TableField("platform_account")
    private String platformAccount;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    public String getPlatformAccount() {
        return platformAccount;
    }

    public void setPlatformAccount(String platformAccount) {
        this.platformAccount = platformAccount;
    }

    public String getYxToken() {
        return yxToken;
    }

    public void setYxToken(String yxToken) {
        this.yxToken = yxToken;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getSignText() {
        return signText;
    }

    public void setSignText(String signText) {
        this.signText = signText;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls = photoUrls;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getPlatformAccount() {
        return platformAccount;
    }

    public void setPlatformAccount(String platformAccount) {
        this.platformAccount = platformAccount;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "TbUser{" +
        "uid=" + uid +
        ", recommendId=" + recommendId +
        ", platformAccount=" + platformAccount +
        ", yxToken=" + yxToken +
        ", nickname=" + nickname +
        ", avatarUrl=" + avatarUrl +
        ", realName=" + realName +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", phone=" + phone +
        ", password=" + password +
        ", location=" + location +
        ", vip=" + vip +
        ", signText=" + signText +
        ", enabled=" + enabled +
        ", status=" + status +
        ", point=" + point +
        ", photoUrls=" + photoUrls +
        ", createTime=" + createTime +
        ", lastUpdated=" + lastUpdated +
        ", platformAccount=" + platformAccount +
        "}";
    }
}
