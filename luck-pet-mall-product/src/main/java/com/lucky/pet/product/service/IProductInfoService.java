package com.lucky.pet.product.service;

import java.util.List;
import com.lucky.pet.common.core.domain.entity.ProductInfo;
import com.lucky.pet.common.core.domain.vo.CommentOv;
import com.lucky.pet.common.core.domain.vo.GoodsOv;
import com.lucky.pet.common.core.domain.vo.ListImagesOv;

/**
 * 商品信息Service接口
 *
 * @author qgj
 * @date 2022-06-20
 */
public interface IProductInfoService
{
    /**
     * 查询商品信息
     *
     * @param productId 商品信息主键
     * @return 商品信息
     */
    public ProductInfo selectProductInfoByProductId(Long productId);

    /**
     * 查询商品信息列表
     *
     * @param productInfo 商品信息
     * @return 商品信息集合
     */
    public List<ProductInfo> selectProductInfoList(ProductInfo productInfo);

    /**
     * 新增商品信息
     *
     * @param productInfo 商品信息
     * @return 结果
     */
    public int insertProductInfo(ProductInfo productInfo);

    /**
     * 修改商品信息
     *
     * @param productInfo 商品信息
     * @return 结果
     */
    public int updateProductInfo(ProductInfo productInfo);

    /**
     * 批量删除商品信息
     *
     * @param productIds 需要删除的商品信息主键集合
     * @return 结果
     */
    public int deleteProductInfoByProductIds(Long[] productIds);

    /**
     * 删除商品信息信息
     *
     * @param productId 商品信息主键
     * @return 结果
     */
    public int deleteProductInfoByProductId(Long productId);

    /**
     * uniapp 查询推荐商品 无限加载
     * @return
     */
    List<ProductInfo> selectProductListByUniappIndex();

    GoodsOv selectProductInfoById(Long id,Long userId);

    List<CommentOv> selectProductCommentByPid(Long id);

    List<CommentOv> selectProductCommentByPidHot(Long id);
}
