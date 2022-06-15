package com.lucky.pet.category.service.impl;

import java.util.List;
import com.lucky.pet.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucky.pet.category.mapper.ProductCategoryMapper;
import com.lucky.pet.common.core.domain.entity.ProductCategory;
import com.lucky.pet.category.service.IProductCategoryService;

/**
 * 商品类目Service业务层处理
 *
 * @author qgj
 * @date 2022-06-13
 */
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService
{
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 查询商品类目
     *
     * @param categoryId 商品类目主键
     * @return 商品类目
     */
    @Override
    public ProductCategory selectProductCategoryByCategoryId(Long categoryId)
    {
        return productCategoryMapper.selectProductCategoryByCategoryId(categoryId);
    }

    /**
     * 查询商品类目列表
     *
     * @param productCategory 商品类目
     * @return 商品类目
     */
    @Override
    public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory)
    {
        return productCategoryMapper.selectProductCategoryList(productCategory);
    }

    /**
     * 新增商品类目
     *
     * @param productCategory 商品类目
     * @return 结果
     */
    @Override
    public int insertProductCategory(ProductCategory productCategory)
    {
        productCategory.setCreateTime(DateUtils.getNowDate());
        return productCategoryMapper.insertProductCategory(productCategory);
    }

    /**
     * 修改商品类目
     *
     * @param productCategory 商品类目
     * @return 结果
     */
    @Override
    public int updateProductCategory(ProductCategory productCategory)
    {
        productCategory.setUpdateTime(DateUtils.getNowDate());
        return productCategoryMapper.updateProductCategory(productCategory);
    }

    /**
     * 批量删除商品类目
     *
     * @param categoryIds 需要删除的商品类目主键
     * @return 结果
     */
    @Override
    public int deleteProductCategoryByCategoryIds(Long[] categoryIds)
    {
        return productCategoryMapper.deleteProductCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除商品类目信息
     *
     * @param categoryId 商品类目主键
     * @return 结果
     */
    @Override
    public int deleteProductCategoryByCategoryId(Long categoryId)
    {
        return productCategoryMapper.deleteProductCategoryByCategoryId(categoryId);
    }
}
