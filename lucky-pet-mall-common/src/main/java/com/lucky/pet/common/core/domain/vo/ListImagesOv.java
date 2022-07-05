package com.lucky.pet.common.core.domain.vo;

import com.lucky.pet.common.core.domain.entity.ProductImage;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhiZhou
 * @createDate: 2022/7/5 1:08
 */
public class ListImagesOv  implements Serializable {

    private List<ProductImage> imgs;

    private Long productId;

    public List<ProductImage> getImgs() {
        return imgs;
    }

    public void setImgs(List<ProductImage> imgs) {
        this.imgs = imgs;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
