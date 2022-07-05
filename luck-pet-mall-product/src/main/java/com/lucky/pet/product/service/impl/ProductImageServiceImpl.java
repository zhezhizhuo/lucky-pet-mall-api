package com.lucky.pet.product.service.impl;

import java.util.List;

import com.lucky.pet.common.core.domain.vo.ListImagesOv;
import com.lucky.pet.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucky.pet.product.mapper.ProductImageMapper;
import com.lucky.pet.common.core.domain.entity.ProductImage;
import com.lucky.pet.product.service.IProductImageService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 商品图片一个图片对应多个商品Service业务层处理
 *
 * @author qgj
 * @date 2022-06-21
 */
@Service
public class ProductImageServiceImpl implements IProductImageService
{
    @Resource
    private ProductImageMapper productImageMapper;

    /**
     * 查询商品图片一个图片对应多个商品
     *
     * @param id 商品图片一个图片对应多个商品主键
     * @return 商品图片一个图片对应多个商品
     */
    @Override
    public ProductImage selectProductImageById(Long id)
    {
        return productImageMapper.selectProductImageById(id);
    }

    /**
     * 查询商品图片一个图片对应多个商品列表
     *
     * @param productImage 商品图片一个图片对应多个商品
     * @return 商品图片一个图片对应多个商品
     */
    @Override
    public List<ProductImage> selectProductImageList(ProductImage productImage)
    {
        return productImageMapper.selectProductImageList(productImage);
    }

    /**
     * 新增商品图片一个图片对应多个商品
     *
     * @param productImage 商品图片一个图片对应多个商品
     * @return 结果
     */
    @Override
    public int insertProductImage(ProductImage productImage)
    {
        productImage.setCreateTime(DateUtils.getNowDate());
        return productImageMapper.insertProductImage(productImage);
    }

    /**
     * 新增商品图片一个图片对应多个商品
     *
     * @param productImage 商品图片一个图片对应多个商品
     * @return 结果
     */
    @Override
    public int insertProductImages(List<ProductImage> productImage)
    {

        return productImageMapper.insertProductImages(productImage);
    }

    /**
     * 修改商品图片一个图片对应多个商品
     *
     * @param productImage 商品图片一个图片对应多个商品
     * @return 结果
     */
    @Override
    public int updateProductImage(ProductImage productImage)
    {
        productImage.setUpdateTime(DateUtils.getNowDate());
        return productImageMapper.updateProductImage(productImage);
    }

    /**
     * 批量删除商品图片一个图片对应多个商品
     *
     * @param ids 需要删除的商品图片一个图片对应多个商品主键
     * @return 结果
     */
    @Override
    public int deleteProductImageByIds(Long[] ids)
    {
        return productImageMapper.deleteProductImageByIds(ids);
    }

    /**
     * 删除商品图片一个图片对应多个商品信息
     *
     * @param id 商品图片一个图片对应多个商品主键
     * @return 结果
     */
    @Override
    public int deleteProductImageById(Long id)
    {
        return productImageMapper.deleteProductImageById(id);
    }

    /**
      根据商品id查询所有图片
     * @param productId
     * @return
     */
    @Override
    public List<ProductImage> selectProductImgByPid(Long productId) {
        return productImageMapper.selectProductImgByPid(productId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProductImages(ListImagesOv listImagesOv) {
        deleteProductImgByProductId(listImagesOv.getProductId());
        //修改商品的id
        listImagesOv.getImgs().stream().forEach(e ->{
            if (e.getImg().equals("")||e.getImg()==null){
                return;
            }
            e.setProductId(listImagesOv.getProductId());
        });
        return  insertProductImages(listImagesOv.getImgs());
    }

    private void deleteProductImgByProductId(Long productId) {
        productImageMapper.deleteProductImgByProductId(productId);
    }
}
