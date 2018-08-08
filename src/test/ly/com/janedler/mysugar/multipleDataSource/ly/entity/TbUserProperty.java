package com.janedler.mysugar.multipleDataSource.ly.entity;

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
@TableName("tb_user_property")
public class TbUserProperty extends Model<TbUserProperty> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Integer uid;
    /**
     * 资产Id
     */
    private Integer pid;
    /**
     * 数量
     */
    private Integer count;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "TbUserProperty{" +
        "uid=" + uid +
        ", pid=" + pid +
        ", count=" + count +
        "}";
    }
}
