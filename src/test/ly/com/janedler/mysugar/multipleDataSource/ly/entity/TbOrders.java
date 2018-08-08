package com.janedler.mysugar.multipleDataSource.ly.entity;

import java.math.BigDecimal;
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
@TableName("tb_orders")
public class TbOrders extends Model<TbOrders> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id(待定：自增序列 or 用户自定义订单号)
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 0充值，1购买礼物，2提现
     */
    @TableField("order_type")
    private Integer orderType;
    /**
     * 订单说明
     */
    private String comment;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 涉及的金额
     */
    private BigDecimal money;
    /**
     * 是否完成
     */
    private Boolean done;
    /**
     * 订单完成时间
     */
    @TableField("completed_time")
    private LocalDateTime completedTime;
    /**
     * 订单创建时间
     */
    @TableField("create_time")
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDateTime getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(LocalDateTime completedTime) {
        this.completedTime = completedTime;
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
        return "TbOrders{" +
        "id=" + id +
        ", uid=" + uid +
        ", orderType=" + orderType +
        ", comment=" + comment +
        ", count=" + count +
        ", money=" + money +
        ", done=" + done +
        ", completedTime=" + completedTime +
        ", createTime=" + createTime +
        "}";
    }
}
