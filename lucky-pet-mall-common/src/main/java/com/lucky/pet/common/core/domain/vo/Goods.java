package com.lucky.pet.common.core.domain.vo;

import com.lucky.pet.common.core.domain.entity.ProductInfo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 24556
 */
public class Goods implements Serializable {


        private Long id;

        private String name;
        private String desc;

        private String picture;

        private BigDecimal price;

        public Goods() {
        }


        public Goods(ProductInfo product) {
                this.id = product.getProductId();
                this.name = product.getProductName();
                this.desc = product.getDescript();
                this.picture = product.getPicture();
                this.price = product.getPrice();
//                this.count = product.getCount();
        }

        private Long count;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDesc() {
                return desc;
        }

        public void setDesc(String desc) {
                this.desc = desc;
        }

        public String getPicture() {
                return picture;
        }

        public void setPicture(String picture) {
                this.picture = picture;
        }

        public BigDecimal getPrice() {
                return price;
        }

        public void setPrice(BigDecimal price) {
                this.price = price;
        }

        public Long getCount() {
                return count;
        }

        public void setCount(Long count) {
                this.count = count;
        }
}
