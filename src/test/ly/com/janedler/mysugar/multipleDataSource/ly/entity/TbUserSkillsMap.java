package com.janedler.mysugar.multipleDataSource.ly.entity;

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
@TableName("tb_user_skills_map")
public class TbUserSkillsMap extends Model<TbUserSkillsMap> {

    private static final long serialVersionUID = 1L;

    /**
     * user id
     */
    private Integer uid;
    /**
     * 技能id
     */
    @TableField("skill_id")
    private Integer skillId;
    /**
     * 技能 URL
     */
    @TableField("skill_url")
    private String skillUrl;
    /**
     * 技能名称
     */
    @TableField("skill_name")
    private String skillName;
    /**
     * 0初始值 1待审核 2审核中 3审核通过 驳回审核
     */
    private Integer state;
    /**
     * 技能描述
     */
    private String description;
    /**
     * 驳回原因
     */
    @TableField("failure_cause")
    private String failureCause;
    /**
     * 开关1 开启 2关闭 3 删除
     */
    private Integer enable;
    /**
     * 服务时间(周)
     */
    @TableField("service_time")
    private String serviceTime;
    /**
     * 额外技能图片
     */
    @TableField("skill_extra_url")
    private String skillExtraUrl;
    /**
     * 语音咨询
     */
    @TableField("online_voice")
    private Boolean onlineVoice;
    /**
     * 视频咨询
     */
    @TableField("online_video")
    private Boolean onlineVideo;
    /**
     * 来店
     */
    @TableField("home_serv")
    private Boolean homeServ;
    /**
     * 上门
     */
    @TableField("to_home_serv")
    private Boolean toHomeServ;
    /**
     * 创建时间戳
     */
    @TableField("create_time")
    private LocalDateTime createTime;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillUrl() {
        return skillUrl;
    }

    public void setSkillUrl(String skillUrl) {
        this.skillUrl = skillUrl;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFailureCause() {
        return failureCause;
    }

    public void setFailureCause(String failureCause) {
        this.failureCause = failureCause;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getSkillExtraUrl() {
        return skillExtraUrl;
    }

    public void setSkillExtraUrl(String skillExtraUrl) {
        this.skillExtraUrl = skillExtraUrl;
    }

    public Boolean getOnlineVoice() {
        return onlineVoice;
    }

    public void setOnlineVoice(Boolean onlineVoice) {
        this.onlineVoice = onlineVoice;
    }

    public Boolean getOnlineVideo() {
        return onlineVideo;
    }

    public void setOnlineVideo(Boolean onlineVideo) {
        this.onlineVideo = onlineVideo;
    }

    public Boolean getHomeServ() {
        return homeServ;
    }

    public void setHomeServ(Boolean homeServ) {
        this.homeServ = homeServ;
    }

    public Boolean getToHomeServ() {
        return toHomeServ;
    }

    public void setToHomeServ(Boolean toHomeServ) {
        this.toHomeServ = toHomeServ;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "TbUserSkillsMap{" +
        "uid=" + uid +
        ", skillId=" + skillId +
        ", skillUrl=" + skillUrl +
        ", skillName=" + skillName +
        ", state=" + state +
        ", description=" + description +
        ", failureCause=" + failureCause +
        ", enable=" + enable +
        ", serviceTime=" + serviceTime +
        ", skillExtraUrl=" + skillExtraUrl +
        ", onlineVoice=" + onlineVoice +
        ", onlineVideo=" + onlineVideo +
        ", homeServ=" + homeServ +
        ", toHomeServ=" + toHomeServ +
        ", createTime=" + createTime +
        "}";
    }
}
