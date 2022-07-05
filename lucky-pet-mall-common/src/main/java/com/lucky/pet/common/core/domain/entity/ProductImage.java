package com.lucky.pet.common.core.domain.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.lucky.pet.common.annotation.Excel;
import com.lucky.pet.common.core.domain.BaseEntity;

/**
 * 商品图片一个图片对应多个商品对象 product_image
 *
 * @author qgj
 * @date 2022-06-21
 */
@ApiModel(value="商品图片一个图片对应多个商品",description =" product_image")
public class ProductImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
     @ApiModelProperty(value ="${comment}",required=true)
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
     @ApiModelProperty(value ="商品id",required=true)
    private Long productId;

    /** 图片路径 */
    @Excel(name = "图片路径")
     @ApiModelProperty(value ="图片路径",required=true)
    private String img;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId()
    {
        return productId;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("img", getImg())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
