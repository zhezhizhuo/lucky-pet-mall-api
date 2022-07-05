package com.lucky.pet.product.mapper;
import java.util.List;

import com.lucky.pet.common.core.domain.entity.ProductImage;
import com.lucky.pet.common.core.domain.entity.ProductInfo;
import com.lucky.pet.common.core.domain.vo.CategorysOv;
import com.lucky.pet.common.core.domain.vo.GoodsHotOv;
import com.lucky.pet.common.core.domain.vo.GoodsOv;
import org.apache.ibatis.annotations.Param;

/**
 * 商品信息Mapper接口
 *
 * @author qgj
 * @date 2022-06-20
 */

public interface ProductInfoMapper
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
     * 删除商品信息
     *
     * @param productId 商品信息主键
     * @return 结果
     */
    public int deleteProductInfoByProductId(Long productId);

    /**
     * 批量删除商品信息
     *
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductInfoByProductIds(Long[] productIds);
    /**
     * uniapp 查询推荐商品 无限加载
     * @return
     */
    List<ProductInfo> selectProductListByUniappIndex();

    GoodsOv selectGoodInfoByProductId(@Param("id") Long id, @Param("userId") Long userId);

    List<ProductImage> selectProductImgagesByPid(Long id);

    List<GoodsHotOv> selectGoodsHotByDay();

    CategorysOv selectProductParent(Long id);

    CategorysOv selectCategorParent(String parent);
}
