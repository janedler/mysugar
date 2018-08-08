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
@TableName("tb_user_post_comments")
public class TbUserPostComments extends Model<TbUserPostComments> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 朋友圈消息ID
     */
    @TableField("post_id")
    private Integer postId;
    /**
     * 留言人
     */
    @TableField("c_uid")
    private Integer cUid;
    /**
     * 对谁留言（回复某某人)
     */
    @TableField("t_uid")
    private Integer tUid;
    /**
     * 标记这条评论是否是点赞
     */
    private Boolean star;
    /**
     * 评论内容（有长度限制)
     */
    private String comment;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getcUid() {
        return cUid;
    }

    public void setcUid(Integer cUid) {
        this.cUid = cUid;
    }

    public Integer gettUid() {
        return tUid;
    }

    public void settUid(Integer tUid) {
        this.tUid = tUid;
    }

    public Boolean getStar() {
        return star;
    }

    public void setStar(Boolean star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbUserPostComments{" +
        "id=" + id +
        ", postId=" + postId +
        ", cUid=" + cUid +
        ", tUid=" + tUid +
        ", star=" + star +
        ", comment=" + comment +
        "}";
    }
}
