package com.lucky.pet.common.core.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhiZhou
 * @createDate: 2022/6/19 19:18
 */
@ApiModel("轮播图  数据模型")

public class PcBanner {

    @ApiModelProperty(value = "跳转的商品ID")
    private String pid;
    @ApiModelProperty(value = "跳转分类")
    private String hrefUrl;

    @ApiModelProperty(value = "轮博图片地址")
    private String imgUrl;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
