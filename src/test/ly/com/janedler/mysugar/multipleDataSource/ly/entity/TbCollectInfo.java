package com.janedler.mysugar.multipleDataSource.ly.entity;

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
@TableName("tb_collect_info")
public class TbCollectInfo extends Model<TbCollectInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏人
     */
    @TableId("collector_id")
    private Integer collectorId;
    /**
     * 被收藏的人
     */
    @TableField("collected_id")
    private Integer collectedId;
    /**
     * 最后修改日期
     */
    @TableField("create_time")
    private LocalDateTime createTime;


    public Integer getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    public Integer getCollectedId() {
        return collectedId;
    }

    public void setCollectedId(Integer collectedId) {
        this.collectedId = collectedId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.collectorId;
    }

    @Override
    public String toString() {
        return "TbCollectInfo{" +
        "collectorId=" + collectorId +
        ", collectedId=" + collectedId +
        ", createTime=" + createTime +
        "}";
    }
}
