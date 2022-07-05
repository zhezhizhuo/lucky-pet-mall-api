package com.lucky.pet.category.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.lucky.pet.common.core.domain.TreeSelect;
import com.lucky.pet.common.core.domain.vo.CategoryOv;
import com.lucky.pet.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucky.pet.category.mapper.ProductCategoryMapper;
import com.lucky.pet.common.core.domain.entity.ProductCategory;
import com.lucky.pet.category.service.IProductCategoryService;

import javax.annotation.Resource;

/**
 * 商品类目Service业务层处理
 *
 * @author qgj
 * @date 2022-06-13
 */
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService
{
    @Resource
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
    /**
     * 获取uniapp 九宫格数据
     * @return
     */
    @Override
    public List<ProductCategory> selectCategoryNineHouseGridList() {
        return productCategoryMapper.selectCategoryNineHouseGridList();
    }
    /**
     * uniapp
     * 查询分类下的所有商品
     * @param
     * @return
     */
    @Override
    public List<CategoryOv> selectHomeProductCategoryList() {
        return productCategoryMapper.selectHomeProductCategoryList();
    }

    @Override
    public List<CategoryOv> selectHomeProductCategoryListTop() {
        return productCategoryMapper.selectHomeProductCategoryListTop();
    }

    @Override
    public List<TreeSelect> buildCategoryTreeSelect(List<ProductCategory> categories) {
            List<ProductCategory> build   =buildCategoryTree(categories);
        return build.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    private List<ProductCategory> buildCategoryTree(List<ProductCategory> categories) {
        List<ProductCategory> returnList = new ArrayList<ProductCategory>();

        List<Long> tempList = new ArrayList<Long>();
        for (ProductCategory category : categories)
        {
            tempList.add(category.getCategoryId());
        }
        for (Iterator<ProductCategory> iterator = categories.iterator(); iterator.hasNext();)
        {
            ProductCategory categoryBean = (ProductCategory) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(Long.valueOf(categoryBean.getParentId())))
            {
                recursionFn(categories, categoryBean);
                returnList.add(categoryBean);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = categories;
        }
        return returnList;
    }

    private List<ProductCategory> recursionFn(List<ProductCategory> categorys, ProductCategory categoryBean) {
        List<ProductCategory> childList= getChildList(categorys, categoryBean);
        categoryBean.setChildren(childList);

        for (ProductCategory bean : childList) {
            if(hasChild(childList,bean)){
                recursionFn(categorys,bean);
            }
        }
        return childList;
    }

    private boolean hasChild(List<ProductCategory> childList, ProductCategory bean) {
        return getChildList(childList, bean).size() > 0;
    }
    private List<ProductCategory> getChildList(List<ProductCategory> categorys, ProductCategory categoryBean) {
        List<ProductCategory> tlist = new ArrayList<ProductCategory>();
        Iterator<ProductCategory> it = categorys.iterator();
        while (it.hasNext())
        {
            ProductCategory n = (ProductCategory) it.next();

            if (n.getParentId().equals(String.valueOf(categoryBean.getCategoryId())))
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
}
