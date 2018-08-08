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
@TableName("tb_user_message")
public class TbUserMessage extends Model<TbUserMessage> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * uid
     */
    private Integer uid;
    /**
     * 消息类型1 添加/拒绝好
     */
    private Integer msgType;
    /**
     * 消息来源
     */
    private Integer uidFrom;
    /**
     * 额外消息
     */
    private String extraMsg;
    /**
     * 礼物 id
     */
    private Integer giftId;
    /**
     * 消息状态
     */
    private Integer state;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;


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

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getUidFrom() {
        return uidFrom;
    }

    public void setUidFrom(Integer uidFrom) {
        this.uidFrom = uidFrom;
    }

    public String getExtraMsg() {
        return extraMsg;
    }

    public void setExtraMsg(String extraMsg) {
        this.extraMsg = extraMsg;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        return "TbUserMessage{" +
        "id=" + id +
        ", uid=" + uid +
        ", msgType=" + msgType +
        ", uidFrom=" + uidFrom +
        ", extraMsg=" + extraMsg +
        ", giftId=" + giftId +
        ", state=" + state +
        ", createTime=" + createTime +
        "}";
    }
}
