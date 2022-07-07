package com.lucky.pet.common.core.domain.vo;


import com.lucky.pet.common.core.domain.entity.ProductCategory;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 24556
 */
public class CategoryTreeOv implements Serializable {

    private String id;

    private String name;

    private String picture;

    List<CategoryTreeOv>  children;

    public CategoryTreeOv() {
    }

    public CategoryTreeOv(ProductCategory categoryBean) {
        this.id = String.valueOf(categoryBean.getCategoryId());
        this.name = categoryBean.getCategoryName();
        this.picture = categoryBean.getPicture();
        if (categoryBean.getChildren() != null) {
            this.children = categoryBean.getChildren().stream().map(CategoryTreeOv::new).collect(Collectors.toList());
        }
        this.goods = categoryBean.getGoods();
    }

    List<Goods> goods;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<CategoryTreeOv> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryTreeOv> children) {
        this.children = children;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
