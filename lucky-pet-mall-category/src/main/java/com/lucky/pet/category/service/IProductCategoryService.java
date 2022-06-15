package com.lucky.pet.category.service;

import java.util.List;
import com.lucky.pet.common.core.domain.entity.ProductCategory;

/**
 * 商品类目Service接口
 *
 * @author qgj
 * @date 2022-06-13
 */
public interface IProductCategoryService
{
    /**
     * 查询商品类目
     *
     * @param categoryId 商品类目主键
     * @return 商品类目
     */
    public ProductCategory selectProductCategoryByCategoryId(Long categoryId);

    /**
     * 查询商品类目列表
     *
     * @param productCategory 商品类目
     * @return 商品类目集合
     */
    public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory);

    /**
     * 新增商品类目
     *
     * @param productCategory 商品类目
     * @return 结果
     */
    public int insertProductCategory(ProductCategory productCategory);

    /**
     * 修改商品类目
     *
     * @param productCategory 商品类目
     * @return 结果
     */
    public int updateProductCategory(ProductCategory productCategory);

    /**
     * 批量删除商品类目
     *
     * @param categoryIds 需要删除的商品类目主键集合
     * @return 结果
     */
    public int deleteProductCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除商品类目信息
     *
     * @param categoryId 商品类目主键
     * @return 结果
     */
    public int deleteProductCategoryByCategoryId(Long categoryId);
}
