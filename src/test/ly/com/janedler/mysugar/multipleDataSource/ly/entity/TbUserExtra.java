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
@TableName("tb_user_extra")
public class TbUserExtra extends Model<TbUserExtra> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户
     */
    private Integer uid;
    /**
     * 身高
     */
    private String height;
    /**
     * 体重
     */
    private String weight;
    /**
     * 学历
     */
    private String education;
    /**
     * 性格
     */
    private String personality;
    /**
     * 婚姻
     */
    private String marriage;
    /**
     * 职业
     */
    private String career;
    /**
     * 出生地址
     */
    private String birthPlace;
    /**
     * 当前所在地
     */
    private String currentLocation;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
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
        return "TbUserExtra{" +
        "id=" + id +
        ", uid=" + uid +
        ", height=" + height +
        ", weight=" + weight +
        ", education=" + education +
        ", personality=" + personality +
        ", marriage=" + marriage +
        ", career=" + career +
        ", birthPlace=" + birthPlace +
        ", currentLocation=" + currentLocation +
        ", lastModTime=" + lastModTime +
        "}";
    }
}
