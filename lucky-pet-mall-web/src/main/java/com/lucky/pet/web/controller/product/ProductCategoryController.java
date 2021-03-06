package com.lucky.pet.web.controller.product;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lucky.pet.category.service.IProductCategoryService;
import io.swagger.annotations.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lucky.pet.common.annotation.Log;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.enums.BusinessType;
import com.lucky.pet.common.core.domain.entity.ProductCategory;
import com.lucky.pet.common.utils.poi.ExcelUtil;

/**
 * 商品类目Controller
 *
 * @author qgj
 * @date 2022-06-13
 */
@RestController

@Api( tags = "商品类目 接口")
@RequestMapping("/product/category")
public class ProductCategoryController extends BaseController {
    @Resource
    private IProductCategoryService productCategoryService;

    /**
     * 查询商品类目列表
     */
    @ApiOperation(value = "查询商品类目列表")
    @ApiOperationSupport( ignoreParameters ="children")
    @PreAuthorize("@ss.hasPermi('category:category:list')")
    @GetMapping("/list")
    public AjaxResult list(ProductCategory productCategory) {
        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        return AjaxResult.success(list);
    }

    @PreAuthorize("@ss.hasPermi('category:category:edit')")
    @Log(title = "获取每个分类占比的数据", businessType = BusinessType.UPDATE)
    @GetMapping("chart")
    public AjaxResult chartData(){
        return AjaxResult.success(productCategoryService.getCharData());
    }

    /**
     * 获取商品类目的下拉树列表
     */
    @ApiOperation(value = "查询商品类目列表")
    @PreAuthorize("@ss.hasPermi('category:category:list')")
    @GetMapping("/treeselect")
    public AjaxResult treeselect(@ApiParam ProductCategory productCategory) {
        List<ProductCategory> categories = productCategoryService.selectProductCategoryList(productCategory);
        return AjaxResult.success(productCategoryService.buildCategoryTreeSelect(categories));
    }
    /**
     * 导出商品类目列表
     */
    @ApiOperation(value = "导出商品类目列表")
    @ApiOperationSupport( ignoreParameters ="children")
    @PreAuthorize("@ss.hasPermi('category:category:export')")
    @Log(title = "商品类目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductCategory productCategory) {
        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        ExcelUtil<ProductCategory> util = new ExcelUtil<ProductCategory>(ProductCategory. class);
        util.exportExcel(response, list, "商品类目数据");
    }

    /**
     * 获取商品类目详细信息
     */
    @ApiOperation(value = "获取商品类目详细信息")
    @PreAuthorize("@ss.hasPermi('category:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId) {
        return AjaxResult.success(productCategoryService.selectProductCategoryByCategoryId(categoryId));
    }

    /**
     * 新增商品类目
     */
    @ApiOperation(value = "新增商品类目")
    @ApiOperationSupport( ignoreParameters ="children")
    @PreAuthorize("@ss.hasPermi('category:category:add')")
    @Log(title = "商品类目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductCategory productCategory) {
        return toAjax(productCategoryService.insertProductCategory(productCategory));
    }

    /**
     * 修改商品类目
     */
    @ApiOperation(value = "修改商品类目")
    @ApiOperationSupport( ignoreParameters ="children")
    @PreAuthorize("@ss.hasPermi('category:category:edit')")
    @Log(title = "商品类目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductCategory productCategory) {
        return toAjax(productCategoryService.updateProductCategory(productCategory));
    }

    /**
     * 删除商品类目
     */
    @ApiOperation(value = "删除商品类目")
    @PreAuthorize("@ss.hasPermi('category:category:remove')")
    @Log(title = "商品类目", businessType = BusinessType.DELETE)
    @ApiImplicitParam(name ="categoryIds",dataTypeClass=List.class,value = "商品分类id 要求数组")
    @DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds) {
        return toAjax(productCategoryService.deleteProductCategoryByCategoryIds(categoryIds));
    }
}
