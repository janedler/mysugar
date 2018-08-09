package com.janedler.mysugar.db.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author dgd123
 * @since 2018-08-09
 */
@Data
@TableName("tb_circle_friends_comments")
public class TbCircleFriendsComments extends Model<TbCircleFriendsComments> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 发表评论的id
     */
    @TableField("from_uid")
    private Integer fromUid;
    @TableField("to_uid")
    private Integer toUid;
    /**
     * 发表文章id
     */
    @TableField("pulish_id")
    private Integer pulishId;
    /**
     * 评论id
     */
    @TableField("comment_id")
    private Integer commentId;
    /**
     * 评论内容
     */
    private String content;
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPulishId() {
        return pulishId;
    }

    public void setPulishId(Integer pulishId) {
        this.pulishId = pulishId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "TbCircleFriendsComments{" +
        "id=" + id +
        ", fromUid=" + fromUid +
        ", toUid=" + toUid +
        ", pulishId=" + pulishId +
        ", commentId=" + commentId +
        ", content=" + content +
        ", createTime=" + createTime +
        "}";
    }
}
