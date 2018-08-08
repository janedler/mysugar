package com.janedler.mysugar.multipleDataSource.ly.entity;

import java.math.BigDecimal;
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
@TableName("tb_money_account")
public class TbMoneyAccount extends Model<TbMoneyAccount> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Integer uid;
    /**
     * 猎影积分（影券)
     */
    @TableField("ly_score")
    private Integer lyScore;
    /**
     * 账户余额
     */
    private BigDecimal money;
    /**
     * 加密后的交易密码
     */
    @TableField("trade_password")
    private String tradePassword;
    /**
     * 银行卡号
     */
    @TableField("card_number")
    private String cardNumber;
    /**
     * 真实姓名，仅用于银行卡支付
     */
    @TableField("real_name")
    private String realName;
    /**
     * 银行验证的手机号码
     */
    private String phone;
    /**
     * 是否验证成功
     */
    private Boolean verified;
    /**
     * 银行卡成功绑定的日期， 存储utc格式时间
     */
    @TableField("bind_timestamp")
    private LocalDateTime bindTimestamp;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLyScore() {
        return lyScore;
    }

    public void setLyScore(Integer lyScore) {
        this.lyScore = lyScore;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public LocalDateTime getBindTimestamp() {
        return bindTimestamp;
    }

    public void setBindTimestamp(LocalDateTime bindTimestamp) {
        this.bindTimestamp = bindTimestamp;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "TbMoneyAccount{" +
        "uid=" + uid +
        ", lyScore=" + lyScore +
        ", money=" + money +
        ", tradePassword=" + tradePassword +
        ", cardNumber=" + cardNumber +
        ", realName=" + realName +
        ", phone=" + phone +
        ", verified=" + verified +
        ", bindTimestamp=" + bindTimestamp +
        "}";
    }
}
