package com.lucky.pet.common.core.domain.entity;

import com.lucky.pet.common.core.domain.BaseEntity;
import com.lucky.pet.common.annotation.Excel;
import com.lucky.pet.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 评论表 用户评论对象 product_comment
 *
 * @author qgj
 * @date 2022-04-21
 */
@ApiModel("评论表 用户评论")
public class ProductComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论ID */
    @ApiModelProperty("评论ID")
    private Long comId;

    /** 父评论 */
    @ApiModelProperty("父评论")
    private Long parentId;

    /** 商品ID */
    @Excel(name = "商品ID")
    @ApiModelProperty("商品ID")
    private Long pId;

    /** 用户ID */
    @Excel(name = "用户ID")
    @ApiModelProperty("用户ID")
    private Long uId;

    /** 评论标签 */
    @Excel(name = "评论标签")
    @ApiModelProperty("评论标签")
    private String tabs;

    /** 评论内容 */
    @Excel(name = "评论内容")
    @ApiModelProperty("评论内容")
    private String content;

    /** 评论状态  */
    @Excel(name = "评论状态 ")
    @ApiModelProperty("评论状态 ")
    private Integer status;

    @Excel(name = "评论人 ")
    @ApiModelProperty("评论人 ")
    private String userName;

    @Excel(name = "商品名称")
    @ApiModelProperty("商品名称 ")
    private String productName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /** 评分 */
    @Excel(name = "评分")
    @ApiModelProperty("评分")
    private String score;

    /** 喜欢人数 */
    @Excel(name = "喜欢人数")
    @ApiModelProperty("喜欢人数")
    private Long praiseCount;

    public void setComId(Long comId)
    {
        this.comId = comId;
    }

    public Long getComId()
    {
        return comId;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }
    public void setpId(Long pId)
    {
        this.pId = pId;
    }

    public Long getpId()
    {
        return pId;
    }
    public void setuId(Long uId)
    {
        this.uId = uId;
    }

    public Long getuId()
    {
        return uId;
    }
    public void setTabs(String tabs)
    {
        this.tabs = tabs;
    }

    public String getTabs()
    {
        return tabs;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setScore(String score)
    {
        this.score = score;
    }

    public String getScore()
    {
        return score;
    }
    public void setPraiseCount(Long praiseCount)
    {
        this.praiseCount = praiseCount;
    }

    public Long getPraiseCount()
    {
        return praiseCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("comId", getComId())
            .append("parentId", getParentId())
            .append("pId", getpId())
            .append("uId", getuId())
            .append("tabs", getTabs())
            .append("content", getContent())
            .append("status", getStatus())
            .append("score", getScore())
            .append("createTime", getCreateTime())
            .append("praiseCount", getPraiseCount())
            .toString();
    }
}
