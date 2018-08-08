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
@TableName("tb_circle_friends_publish")
public class TbCircleFriendsPublish extends Model<TbCircleFriendsPublish> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 发表评论的uid
     */
    private Integer uid;
    /**
     * 主题类型
     */
    @TableField("publish_type")
    private Integer publishType;
    /**
     * 发送的文本
     */
    private String content;
    /**
     * 图片链接
     */
    private String picUrl;
    private LocalDateTime createTime;
    /**
     * 0 默认状态
1 删除状态
     */
    private Integer publishStatus;


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

    public Integer getPublishType() {
        return publishType;
    }

    public void setPublishType(Integer publishType) {
        this.publishType = publishType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbCircleFriendsPublish{" +
        "id=" + id +
        ", uid=" + uid +
        ", publishType=" + publishType +
        ", content=" + content +
        ", picUrl=" + picUrl +
        ", createTime=" + createTime +
        ", publishStatus=" + publishStatus +
        "}";
    }
}
