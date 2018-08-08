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
@TableName("tb_user_skill_comments")
public class TbUserSkillComments extends Model<TbUserSkillComments> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论记录Id
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;
    /**
     * User id
     */
    private Integer uid;
    /**
     * 技能ID
     */
    @TableField("skill_id")
    private Integer skillId;
    /**
     * 评论
     */
    private String comment;
    /**
     * 评论人id
     */
    @TableField("comment_uid")
    private Integer commentUid;
    @TableField("create_time")
    private LocalDateTime createTime;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCommentUid() {
        return commentUid;
    }

    public void setCommentUid(Integer commentUid) {
        this.commentUid = commentUid;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

    @Override
    public String toString() {
        return "TbUserSkillComments{" +
        "cid=" + cid +
        ", uid=" + uid +
        ", skillId=" + skillId +
        ", comment=" + comment +
        ", commentUid=" + commentUid +
        ", createTime=" + createTime +
        "}";
    }
}
