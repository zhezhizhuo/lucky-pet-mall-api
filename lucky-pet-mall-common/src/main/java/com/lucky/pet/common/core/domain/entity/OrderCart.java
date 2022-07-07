package com.lucky.pet.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucky.pet.common.annotation.Excel;
import com.lucky.pet.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户购物车对象 order_cart
 *
 * @author qgj
 * @date 2022-04-23
 */
@ApiModel("用户购物车")
public class OrderCart extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 购物车ID */
    @ApiModelProperty("${comment}")
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    @ApiModelProperty("用户id")
    private Long uId;

    /** 商品id */
    @Excel(name = "商品id")
    @ApiModelProperty("商品id")
    private Long pId;

    /** 商品数量 */
    @Excel(name = "商品数量")
    @ApiModelProperty("商品数量")
    private Long count;

    /** 价格 */
    @Excel(name = "价格")
    @ApiModelProperty("价格")
    private BigDecimal price;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
        @ApiModelProperty("添加时间")
    private Date addTime;

    /** 用户是否删除 */
    @Excel(name = "用户是否删除")
    @ApiModelProperty("用户是否删除")
    private Long isDelete;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setuId(Long uId)
    {
        this.uId = uId;
    }

    public Long getuId()
    {
        return uId;
    }
    public void setpId(Long pId)
    {
        this.pId = pId;
    }

    public Long getpId()
    {
        return pId;
    }
    public void setCount(Long count)
    {
        this.count = count;
    }

    public Long getCount()
    {
        return count;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }

    public Date getAddTime()
    {
        return addTime;
    }
    public void setIsDelete(Long isDelete)
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete()
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uId", getuId())
            .append("pId", getpId())
            .append("count", getCount())
            .append("price", getPrice())
            .append("addTime", getAddTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
