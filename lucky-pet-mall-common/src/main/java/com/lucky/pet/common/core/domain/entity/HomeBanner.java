package com.lucky.pet.common.core.domain.entity;

import com.lucky.pet.common.annotation.Excel;
import com.lucky.pet.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 轮播图片对象 home_banner
 *
 * @author qgj
 * @date 2022-06-16
 */
@ApiModel("轮播图片")
public class HomeBanner extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** ID */
    @ApiModelProperty(hidden = true)
    private Long id;

    /** 跳转商品 */
    @ApiModelProperty("跳转商品")
    private Long pid;

    /** 跳转地址 */
    @Excel(name = "跳转地址")
    @ApiModelProperty("跳转地址")
    private String hrefurl;

    /** 排序 */
    @Excel(name = "排序")
    @ApiModelProperty("排序")
    private Long sort;

    /** 图片 */
    @Excel(name = "图片")
    @ApiModelProperty("图片")
    private String imgurl;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPid(Long pid)
    {
        this.pid = pid;
    }

    public Long getPid()
    {
        return pid;
    }
    public void setHrefurl(String hrefurl)
    {
        this.hrefurl = hrefurl;
    }

    public String getHrefurl()
    {
        return hrefurl;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setImgurl(String imgurl)
    {
        this.imgurl = imgurl;
    }

    public String getImgurl()
    {
        return imgurl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getPid())
            .append("hrefurl", getHrefurl())
            .append("sort", getSort())
            .append("imgurl", getImgurl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
