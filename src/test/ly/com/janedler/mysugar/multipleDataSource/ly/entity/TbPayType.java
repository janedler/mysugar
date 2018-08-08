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
@TableName("tb_pay_type")
public class TbPayType extends Model<TbPayType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 支付类型，支付宝，微信，银行卡
     */
    @TableField("pay_name")
    private String payName;
    /**
     * 禁用开关
     */
    private Boolean enabled;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbPayType{" +
        "id=" + id +
        ", payName=" + payName +
        ", enabled=" + enabled +
        "}";
    }
}
