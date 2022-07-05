package com.lucky.pet.common.core.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhiZhou
 * @createDate: 2022/7/3 14:56
 */
@ApiModel("uniapp 分类  数据模型")
public class CategoryOv {


    @ApiModelProperty(value = "分类名称")
    private String name;
    @ApiModelProperty(value = "分类Id")
    private Long id;
    @ApiModelProperty(value = "分类图片地址")
    private String icon;

    private List<CategoryOv> children;

    public CategoryOv() {
    }

    @Override
    public String toString() {
        return "CategoryOv{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", icon='" + icon + '\'' +
                ", children=" + children +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<CategoryOv> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryOv> children) {
        this.children = children;
    }
}
