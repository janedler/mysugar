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
@TableName("tb_circle_friends_praise")
public class TbCircleFriendsPraise extends Model<TbCircleFriendsPraise> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("publish_id")
    private Integer publishId;
    @TableField("from_uid")
    private Integer fromUid;
    @TableField("to_uid")
    private Integer toUid;
    private LocalDateTime createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
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
        return "TbCircleFriendsPraise{" +
        "id=" + id +
        ", publishId=" + publishId +
        ", fromUid=" + fromUid +
        ", toUid=" + toUid +
        ", createTime=" + createTime +
        "}";
    }
}
