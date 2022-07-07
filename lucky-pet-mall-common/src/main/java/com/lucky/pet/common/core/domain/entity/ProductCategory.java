package com.lucky.pet.common.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucky.pet.common.core.domain.vo.Goods;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.lucky.pet.common.annotation.Excel;

import java.util.Date;
import java.util.List;

/**
 * 商品类目对象 product_category
 *
 * @author qgj
 * @date 2022-06-13
 */
@ApiModel("商品类目")

public class ProductCategory {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类ID")
    private Long categoryId;

    /**
     * 分类名
     */
    @Excel(name = "分类名")
    @ApiModelProperty("分类名")
    private String categoryName;

    /**
     * 0 表示顶级分类
     */
    @ApiModelProperty("分类名")
    private String parentId;

    /**
     * 排序
     */
    @Excel(name = "排序")
    @ApiModelProperty("排序")
    private Long sort;

    /**
     * 0 表示正常 1表示下架
     */
    @Excel(name = "0 表示正常 1表示下架")
    @ApiModelProperty("0 表示正常 1表示下架")
    private Integer pStatus;

    /**
     * PC端icon
     */
    @Excel(name = "PC端icon")
    @ApiModelProperty("PC端icon ")
    private String iconPc;

    @Excel(name = "更新时间")
    @ApiModelProperty(value = "更新时间",hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Excel(name = "创建时间")
    @ApiModelProperty(value = "创建时间",hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty("子分类")
    private List<ProductCategory> children;

    public List<ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategory> children) {
        this.children = children;
    }

    private List<Goods> goods;

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    /**
     * app端icon
     */
    @Excel(name = "app端icon")
    @ApiModelProperty("app端icon")
    private String iconApp;

    /**
     * 分类图片
     */
    @Excel(name = "分类图片")
    @ApiModelProperty("分类图片")
    private String picture;

    /**
     * 分类下的，商品总数
     */
    @Excel(name = "分类下的，商品总数 ")
    @ApiModelProperty("分类下的，商品总数 ")
    private String total;

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setIconPc(String iconPc) {
        this.iconPc = iconPc;
    }

    public String getIconPc() {
        return iconPc;
    }

    public void setIconApp(String iconApp) {
        this.iconApp = iconApp;
    }

    public String getIconApp() {
        return iconApp;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("categoryId" , getCategoryId())
                .append("categoryName" , getCategoryName())
                .append("parentId" , getParentId())
                .append("sort" , getSort())
                .append("pStatus" , getpStatus())
                .append("iconPc" , getIconPc())
                .append("iconApp" , getIconApp())
                .append("picture" , getPicture())
                .append("updateTime" , getUpdateTime())
                .append("createTime" , getCreateTime())
                .append("total" , getTotal())
                .toString();
    }
}
