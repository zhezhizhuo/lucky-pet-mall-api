package com.lucky.pet.product.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.lucky.pet.common.core.domain.entity.ProductCategory;
import com.lucky.pet.common.core.domain.entity.ProductImage;
import com.lucky.pet.common.core.domain.vo.*;
import com.lucky.pet.common.utils.DateUtils;
import com.lucky.pet.common.utils.SecurityUtils;
import com.lucky.pet.product.service.IProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucky.pet.product.mapper.ProductInfoMapper;
import com.lucky.pet.common.core.domain.entity.ProductInfo;
import com.lucky.pet.product.service.IProductInfoService;

import javax.annotation.Resource;

/**
 * 商品信息Service业务层处理
 *
 * @author qgj
 * @date 2022-06-20
 */
@Service
public class ProductInfoServiceImpl implements IProductInfoService
{
    @Resource
    private ProductInfoMapper productInfoMapper;
    @Resource
    private IProductCommentService commentService;
    /**
     * 查询商品信息
     *
     * @param productId 商品信息主键
     * @return 商品信息
     */
    @Override
    public ProductInfo selectProductInfoByProductId(Long productId)
    {
        return productInfoMapper.selectProductInfoByProductId(productId);
    }

    /**
     * 查询商品信息列表
     *
     * @param productInfo 商品信息
     * @return 商品信息
     */
    @Override
    public List<ProductInfo> selectProductInfoList(ProductInfo productInfo)
    {
        return productInfoMapper.selectProductInfoList(productInfo);
    }

    /**
     * 新增商品信息
     *
     * @param productInfo 商品信息
     * @return 结果
     */
    @Override
    public int insertProductInfo(ProductInfo productInfo)
    {
        productInfo.setCreateTime(DateUtils.getNowDate());
        return productInfoMapper.insertProductInfo(productInfo);
    }

    /**
     * 修改商品信息
     *
     * @param productInfo 商品信息
     * @return 结果
     */
    @Override
    public int updateProductInfo(ProductInfo productInfo)
    {
        return productInfoMapper.updateProductInfo(productInfo);
    }

    /**
     * 批量删除商品信息
     *
     * @param productIds 需要删除的商品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductInfoByProductIds(Long[] productIds)
    {
        return productInfoMapper.deleteProductInfoByProductIds(productIds);
    }

    /**
     * 删除商品信息信息
     *
     * @param productId 商品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductInfoByProductId(Long productId)
    {
        return productInfoMapper.deleteProductInfoByProductId(productId);
    }
    /**
     * uniapp 查询推荐商品 无限加载
     * @return
     */
    @Override
    public List<ProductInfo> selectProductListByUniappIndex() {
        return productInfoMapper.selectProductListByUniappIndex();
    }

    @Override
    public List<CommentOv> selectProductCommentByPid(Long id) {
        List<CommentOv> commentEntities = commentService.selectProductCommentByPid(id);
        try {
            commentEntities.stream().forEach( item ->{
                //查看每一个评论是否 用户已经评论
                Long userId = SecurityUtils.getUserId();
                Integer commid = item.getId();
                if (commentService.selectCommByUIdAndComId(userId,commid) !=0){            //用户评论了
                    item.setLike(true);
                }
            });
            return  commentEntities;
        } catch (Exception e){
            e.printStackTrace();
            return commentEntities ;
        }
    }

    @Override
    public List<CommentOv> selectProductCommentByPidHot(Long id) {
        List<CommentOv> commentEntities = commentService.selectProductCommentByPidHot(id);
        try {
            commentEntities.stream().forEach(item -> {
                //查看每一个评论是否 用户已经评论
                Long userId = SecurityUtils.getUserId();
                Integer commid = item.getId();
                if (commentService.selectCommByUIdAndComId(userId, commid) != 0) {            //用户评论了
                    item.setLike(true);
                }
            });
            return commentEntities;
        } catch (Exception e) {
            e.printStackTrace();
            return commentEntities;
        }
    }

    @Override
    public List<CategoryTreeOv> buildCategoryGoods() {
        List<ProductCategory> categories = selectCategoryHead();

        return   buildCategoryGoodsList(categories).stream().map(CategoryTreeOv::new).collect(Collectors.toList());
    }

    @Override
    public ProductInfo selectProductByProductId(Long productId) {
        ProductInfo product = productInfoMapper.selectProductInfoByProductId(productId);
//        product.setMainPictures(getMainPictures(product.getProductId()));
//        product.
        return  product;
    }

    private    List<ProductCategory>  buildCategoryGoodsList(List<ProductCategory> categorys) {
        List<ProductCategory> returns = new ArrayList<>();
        List<Long> temp = new ArrayList<Long>();
        for (ProductCategory categoryBean : categorys)
        {
            temp.add(categoryBean.getCategoryId());
        }
        for (Iterator<ProductCategory> iterator = categorys.iterator(); iterator.hasNext();)
        {
            ProductCategory categoryBean = (ProductCategory) iterator.next();

            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!temp.contains(Long.valueOf(categoryBean.getParentId())))
            {
                categoryBean.setGoods(getGoods(categoryBean.getCategoryId()));
                recursionFn(categorys, categoryBean);
                returns.add(categoryBean);
            }
        }
        if (returns.isEmpty())
        {
            returns = categorys;
        }
        return returns;
    }

    private List<ProductCategory> recursionFn(List<ProductCategory> categorys, ProductCategory categoryBean) {
        List<ProductCategory> childList=      getChildList(categorys, categoryBean);
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
            if (Long.valueOf(n.getParentId()) == categoryBean.getCategoryId().longValue())

            {
                tlist.add(n);
            }
        }
        return tlist;
    }
    private List<Goods> getGoods(Long categoryId) {
        return   productInfoMapper.selectProductListByCategoryId(categoryId).stream().map(Goods::new).collect(Collectors.toList());
    }

    private List<ProductCategory> selectCategoryHead() {
        return productInfoMapper.selectCategoryHead();
    }

    @Override
    public GoodsOv selectProductInfoById(Long id,Long userId) {


        //查询商品
        GoodsOv good = productInfoMapper.selectGoodInfoByProductId(id,userId);

        List<ProductImage> productImages = productInfoMapper.selectProductImgagesByPid(id);
        List<String> imgs = productImages.stream().map(ProductImage::getImg).collect(Collectors.toList());
        if (imgs!=null) {
            good.setMainPictures(imgs);
        }
        List<GoodsHotOv> goods = productInfoMapper.selectGoodsHotByDay();
        good.setCategories(getCategories(id));
        good.setHotByDay(goods);
        return good;
    }


    public List<CategorysOv> getCategories(Long id) {
        List<CategorysOv> categories = new ArrayList<>();
        CategorysOv categorysOv = productInfoMapper.selectProductParent(id);
        if (categorysOv!=null) {
            categories.add(categorysOv);
        }
        CategorysOv categorysOv2 = productInfoMapper.selectCategorParent(categorysOv.getParent());
        if (categorysOv2 !=null){
            categories.add(categorysOv2);
        }
        return categories;
    }
}
