package com.lucky.pet.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucky.pet.common.annotation.Excel;
import com.lucky.pet.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 用户收藏对象 user_collects
 *
 * @author qgj
 * @date 2022-04-19
 */
@ApiModel("用户收藏")
public class UserCollects extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("${comment}")
    private Long colId;

    private String picture;

    private String productName;

    private String userName;


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 商品id */
    @Excel(name = "商品id")
    @ApiModelProperty("商品id")
    private Long pid;

    /** 用户id */
    @Excel(name = "用户id")
    @ApiModelProperty("用户id")
    private Long userId;

    /** 是否删除 */
    @Excel(name = "是否删除")
    @ApiModelProperty("是否删除")
    private Long isDelete;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("添加时间")
    private Date addTime;

    public void setColId(Long colId)
    {
        this.colId = colId;
    }

    public Long getColId()
    {
        return colId;
    }
    public void setPid(Long pid)
    {
        this.pid = pid;
    }

    public Long getPid()
    {
        return pid;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setIsDelete(Long isDelete)
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete()
    {
        return isDelete;
    }
    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }

    public Date getAddTime()
    {
        return addTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("colId", getColId())
            .append("pid", getPid())
            .append("userId", getUserId())
            .append("isDelete", getIsDelete())
            .append("addTime", getAddTime())
            .toString();
    }
}
