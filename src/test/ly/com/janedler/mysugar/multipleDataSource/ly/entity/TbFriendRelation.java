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
@TableName("tb_friend_relation")
public class TbFriendRelation extends Model<TbFriendRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id，发起好友邀请的人
     */
    private Integer uid;
    /**
     * 用户好友id，同意好友邀请的人
     */
    @TableField("friend_uid")
    private Integer friendUid;
    /**
     * 用户A申请成为用户B的好友，用户B是否同意
     */
    private Boolean approved;
    /**
     * 好友关系建立的时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFriendUid() {
        return friendUid;
    }

    public void setFriendUid(Integer friendUid) {
        this.friendUid = friendUid;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
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
        return "TbFriendRelation{" +
        "uid=" + uid +
        ", friendUid=" + friendUid +
        ", approved=" + approved +
        ", createTime=" + createTime +
        "}";
    }
}
