package com.janedler.mysugar.multipleDataSource.ly.entity;

import java.math.BigDecimal;
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
@TableName("tb_property")
public class TbProperty extends Model<TbProperty> {

    private static final long serialVersionUID = 1L;

    /**
     * 资产/礼物 id
     */
    private Integer id;
    /**
     * 资产(礼物)名称
     */
    private String name;
    /**
     * 资产价值
     */
    private BigDecimal price;
    /**
     * 开关控制
     */
    private Boolean enabled;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        return "TbProperty{" +
        "id=" + id +
        ", name=" + name +
        ", price=" + price +
        ", enabled=" + enabled +
        "}";
    }
}
