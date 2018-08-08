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
@TableName("tb_user_friend_relationship")
public class TbUserFriendRelationship extends Model<TbUserFriendRelationship> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer ownUid;
    private Integer otherUid;
    /**
     * 0 默认无关系 1 own喜欢other 2 own和 other相互喜欢 3 own 删除了 other
     */
    private Integer relationshipState;
    private LocalDateTime createTime;
    private LocalDateTime lastModTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnUid() {
        return ownUid;
    }

    public void setOwnUid(Integer ownUid) {
        this.ownUid = ownUid;
    }

    public Integer getOtherUid() {
        return otherUid;
    }

    public void setOtherUid(Integer otherUid) {
        this.otherUid = otherUid;
    }

    public Integer getRelationshipState() {
        return relationshipState;
    }

    public void setRelationshipState(Integer relationshipState) {
        this.relationshipState = relationshipState;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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
        return "TbUserFriendRelationship{" +
        "id=" + id +
        ", ownUid=" + ownUid +
        ", otherUid=" + otherUid +
        ", relationshipState=" + relationshipState +
        ", createTime=" + createTime +
        ", lastModTime=" + lastModTime +
        "}";
    }
}
