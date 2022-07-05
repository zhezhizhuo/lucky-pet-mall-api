package com.lucky.pet.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucky.pet.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 地址管理对象 user_address
 *
 * @author qgj
 * @date 2022-04-18
 */
@ApiModel("地址管理对象")
public class UserAddress
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value = "id",hidden = true)
    private Long id;
    /** 归属用户ID */
    @Excel(name = "归属用户ID")
    @ApiModelProperty(value = "归属用户ID",hidden = true)
    private Long uid;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(required = true, value = "创建时间",hidden = true)
    private Date createTime;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="更新时间",hidden = true)
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 收货人姓名 */
    @Excel(name = "收货人姓名")
    @ApiModelProperty(required = true,value = "收货人姓名")
    private String name;

    /** 省份 */
    @Excel(name = "省份")
    @ApiModelProperty(required = true,value = "省份")
    private String provinceName;

    /** 省-行政代号 */
    @Excel(name = "省-行政代号")
    @ApiModelProperty(required = true,value = "省-行政代号")
    private String provinceCode;

    /** 市  */
    @Excel(name = "市 ")
    @ApiModelProperty(required = true,value = "市")
    private String citiyName;
    /** 区 县 */
    @Excel(name = "区 县")
    @ApiModelProperty(required = true,value = "区 县")

    private String areanName;

    /** 邮政编号 */
    @ApiModelProperty(required = true,value = "邮政编号")
    @Excel(name = "邮政编号")
    private String zip;

    /** 地址详细信息 */

    @Excel(name = "地址详细信息")
    @ApiModelProperty(required = true,value = "地址详细信息")
    private String address;

    /** 收货号码 */
    @Excel(name = "收货号码")
    @ApiModelProperty(required = true,value = "收货号码")
    private String phone;

    /** 标签 */
    @Excel(name = "标签")
    @ApiModelProperty(required = true,value = "标签")
    private String tab;

    /** 是否默认 */
    @Excel(name = "是否默认")
    @ApiModelProperty(value = "是否默认",hidden = true)
    private String isDefault;


    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUid(Long uid)
    {
        this.uid = uid;
    }

    public Long getUid()
    {
        return uid;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }

    public String getProvinceName()
    {
        return provinceName;
    }
    public void setProvinceCode(String provinceCode)
    {
        this.provinceCode = provinceCode;
    }

    public String getProvinceCode()
    {
        return provinceCode;
    }
    public void setCitiyName(String citiyName)
    {
        this.citiyName = citiyName;
    }

    public String getCitiyName()
    {
        return citiyName;
    }
    public void setAreanName(String areanName)
    {
        this.areanName = areanName;
    }

    public String getAreanName()
    {
        return areanName;
    }
    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getZip()
    {
        return zip;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setTab(String tab)
    {
        this.tab = tab;
    }

    public String getTab()
    {
        return tab;
    }
    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
    }

    public String getIsDefault()
    {
        return isDefault;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("name", getName())
            .append("provinceName", getProvinceName())
            .append("provinceCode", getProvinceCode())
            .append("citiyName", getCitiyName())
            .append("areanName", getAreanName())
            .append("zip", getZip())
            .append("address", getAddress())
            .append("phone", getPhone())
            .append("tab", getTab())
            .append("isDefault", getIsDefault())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
