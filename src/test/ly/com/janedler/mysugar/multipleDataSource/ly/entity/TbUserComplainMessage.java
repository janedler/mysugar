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
@TableName("tb_user_complain_message")
public class TbUserComplainMessage extends Model<TbUserComplainMessage> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 被举报人uid
     */
    private Integer uidTo;
    /**
     * 举报人uid
     */
    private Integer uidFrom;
    /**
     * 标准举报消息
     */
    private String message;
    /**
     * 自定义举报消息
     */
    private String extraMessage;
    /**
     * 举报图片
     */
    private String url;
    private LocalDateTime createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUidTo() {
        return uidTo;
    }

    public void setUidTo(Integer uidTo) {
        this.uidTo = uidTo;
    }

    public Integer getUidFrom() {
        return uidFrom;
    }

    public void setUidFrom(Integer uidFrom) {
        this.uidFrom = uidFrom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public void setExtraMessage(String extraMessage) {
        this.extraMessage = extraMessage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return "TbUserComplainMessage{" +
        "id=" + id +
        ", uidTo=" + uidTo +
        ", uidFrom=" + uidFrom +
        ", message=" + message +
        ", extraMessage=" + extraMessage +
        ", url=" + url +
        ", createTime=" + createTime +
        "}";
    }
}
