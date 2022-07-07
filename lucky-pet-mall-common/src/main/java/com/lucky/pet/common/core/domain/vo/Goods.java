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

        private BigDecimal oldPrice;
        private String childrenPic;

        public Goods() {
        }


        public Goods(ProductInfo product) {
                this.id = product.getProductId();
                this.name = product.getProductName();
                this.desc = product.getDescript();
                this.picture = product.getPicture();
                this.price = product.getPrice();
                this.oldPrice = product.getOldPrice();
                this.childrenPic = product.getChildrenPic();
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

        public BigDecimal getOldPrice() {
                return oldPrice;
        }

        public void setOldPrice(BigDecimal oldPrice) {
                this.oldPrice = oldPrice;
        }

        public String getChildrenPic() {
                return childrenPic;
        }

        public void setChildrenPic(String childrenPic) {
                this.childrenPic = childrenPic;
        }
}
