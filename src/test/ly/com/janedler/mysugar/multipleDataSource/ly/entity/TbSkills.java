package com.janedler.mysugar.multipleDataSource.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("tb_skills")
public class TbSkills extends Model<TbSkills> {

    private static final long serialVersionUID = 1L;

    /**
     * 技能Id
     */
    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;
    /**
     * 技能名称
     */
    private String name;
    /**
     * 技能logo
     */
    private String logo;
    /**
     * 技能说明
     */
    private String description;
    /**
     * 服务方式 0线上，1线下
     */
    @TableField("service_type")
    private Integer serviceType;
    /**
     * 1休闲娱乐, 2 其他
     */
    @TableField("skill_type")
    private Integer skillType;
    @TableField("skill_url")
    private String skillUrl;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getSkillType() {
        return skillType;
    }

    public void setSkillType(Integer skillType) {
        this.skillType = skillType;
    }

    public String getSkillUrl() {
        return skillUrl;
    }

    public void setSkillUrl(String skillUrl) {
        this.skillUrl = skillUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.sid;
    }

    @Override
    public String toString() {
        return "TbSkills{" +
        "sid=" + sid +
        ", name=" + name +
        ", logo=" + logo +
        ", description=" + description +
        ", serviceType=" + serviceType +
        ", skillType=" + skillType +
        ", skillUrl=" + skillUrl +
        "}";
    }
}
