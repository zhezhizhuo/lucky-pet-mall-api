package com.lucky.pet.common.core.domain.entity;

import com.lucky.pet.common.annotation.Excel;
import com.lucky.pet.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 商品信息对象 product_info
 *
 * @author qgj
 * @date 2022-06-20
 */
@ApiModel("商品信息")
public class ProductInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    @ApiModelProperty("商品ID")
    private Long productId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    @ApiModelProperty("商品名称")
    private String productName;

    /** 商品价格 */
    @Excel(name = "商品价格")
    @ApiModelProperty("商品价格")
    private BigDecimal price;

    /** 原价格 */
    @Excel(name = "原价格")
    @ApiModelProperty("原价格")
    private BigDecimal oldPrice;

    /** 商品状态 */
    @Excel(name = "商品状态")
    @ApiModelProperty("商品状态")
    private Integer pStatus;

    /** 商品描述 */
    @Excel(name = "商品描述")
    @ApiModelProperty("商品描述")
    private String descript;

    /** 所属类目 */
    @Excel(name = "所属类目")
    @ApiModelProperty("所属类目")
    private String categoryName;

    /** 类目ID */
    @Excel(name = "类目ID")
    @ApiModelProperty("类目ID")
    private Long categoryId;

    /** 0 未删除  1 已删除 */
    @ApiModelProperty("类目ID")
    private Integer isDelete;

    /** 商品图片 */
    @Excel(name = "商品图片")
    @ApiModelProperty("商品图片")
    private String picture;

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId()
    {
        return productId;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setOldPrice(BigDecimal oldPrice)
    {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getOldPrice()
    {
        return oldPrice;
    }
    public void setpStatus(Integer pStatus)
    {
        this.pStatus = pStatus;
    }

    public Integer getpStatus()
    {
        return pStatus;
    }
    public void setDescript(String descript)
    {
        this.descript = descript;
    }

    public String getDescript()
    {
        return descript;
    }
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName()
    {
        return categoryName;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }
    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getPicture()
    {
        return picture;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("price", getPrice())
            .append("oldPrice", getOldPrice())
            .append("pStatus", getpStatus())
            .append("descript", getDescript())
            .append("categoryName", getCategoryName())
            .append("categoryId", getCategoryId())
            .append("createTime", getCreateTime())
            .append("isDelete", getIsDelete())
            .append("picture", getPicture())
            .toString();
    }

    private String childrenPic;

    public void setChildrenPic(String childrenPic) {
        this.childrenPic = childrenPic;
    }

    public String getChildrenPic() {
        return childrenPic;
    }
}
