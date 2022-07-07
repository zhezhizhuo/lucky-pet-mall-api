package com.lucky.pet.category.mapper;
import java.util.List;
import com.lucky.pet.common.core.domain.entity.ProductCategory;
import com.lucky.pet.common.core.domain.vo.CategoryOv;
import com.lucky.pet.common.core.domain.vo.ChartOv;

/**
 * 商品类目Mapper接口
 *
 * @author qgj
 * @date 2022-06-13
 */

public interface ProductCategoryMapper
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
     * 删除商品类目
     *
     * @param categoryId 商品类目主键
     * @return 结果
     */
    public int deleteProductCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除商品类目
     *
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductCategoryByCategoryIds(Long[] categoryIds);
    /**
     * 获取uniapp 九宫格数据
     * @return
     */
    List<ProductCategory> selectCategoryNineHouseGridList();

    List<CategoryOv> selectHomeProductCategoryList();

    List<CategoryOv> selectHomeProductCategoryListTop();

    List<ChartOv> getCharData();
}
