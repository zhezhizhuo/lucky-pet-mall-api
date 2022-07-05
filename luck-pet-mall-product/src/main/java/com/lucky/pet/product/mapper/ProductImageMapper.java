package com.lucky.pet.product.mapper;
import java.util.List;
import com.lucky.pet.common.core.domain.entity.ProductImage;

/**
 * 商品图片一个图片对应多个商品Mapper接口
 *
 * @author qgj
 * @date 2022-06-21
 */

public interface ProductImageMapper
{
    /**
     * 查询商品图片一个图片对应多个商品
     *
     * @param id 商品图片一个图片对应多个商品主键
     * @return 商品图片一个图片对应多个商品
     */
    public ProductImage selectProductImageById(Long id);

    /**
     * 查询商品图片一个图片对应多个商品列表
     *
     * @param productImage 商品图片一个图片对应多个商品
     * @return 商品图片一个图片对应多个商品集合
     */
    public List<ProductImage> selectProductImageList(ProductImage productImage);

    /**
     * 新增商品图片一个图片对应多个商品
     *
     * @param productImage 商品图片一个图片对应多个商品
     * @return 结果
     */
    public int insertProductImage(ProductImage productImage);

    /**
     * 修改商品图片一个图片对应多个商品
     *
     * @param productImage 商品图片一个图片对应多个商品
     * @return 结果
     */
    public int updateProductImage(ProductImage productImage);

    /**
     * 删除商品图片一个图片对应多个商品
     *
     * @param id 商品图片一个图片对应多个商品主键
     * @return 结果
     */
    public int deleteProductImageById(Long id);

    /**
     * 批量删除商品图片一个图片对应多个商品
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductImageByIds(Long[] ids);

    /**
     *    根据商品id查询所有图片
     * @param productId
     * @return
     */
    List<ProductImage> selectProductImgByPid(Long productId);

    int insertProductImages(List<ProductImage> productImage);

    void deleteProductImgByProductId(Long productId);
}
