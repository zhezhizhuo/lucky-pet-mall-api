package com.lucky.pet.web.controller.product;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lucky.pet.common.core.domain.entity.ProductImage;
import com.lucky.pet.common.core.domain.vo.ListImagesOv;
import com.lucky.pet.product.service.IProductImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
import com.lucky.pet.common.core.domain.entity.ProductInfo;
import com.lucky.pet.product.service.IProductInfoService;
import com.lucky.pet.common.utils.poi.ExcelUtil;
import com.lucky.pet.common.core.page.TableDataInfo;

/**
 * 商品信息Controller
 *
 * @author qgj
 * @date 2022-06-20
 */
@RestController

@Api( tags = "商品信息 接口")
@RequestMapping("/product/product")
public class ProductInfoController extends BaseController {
    @Resource
    private IProductInfoService productInfoService;

    @Resource
    private IProductImageService iProductImageService;

    /**
     * 查询商品信息列表
     */
    @ApiOperation(value = "查询商品信息列表")
    @PreAuthorize("@ss.hasPermi('product:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductInfo productInfo) {
        startPage();

        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @ApiOperation(value = "导出商品信息列表")
    @PreAuthorize("@ss.hasPermi('product:product:export')")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductInfo productInfo) {
        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        ExcelUtil<ProductInfo> util = new ExcelUtil<ProductInfo>(ProductInfo. class);
        util.exportExcel(response, list, "商品信息数据");
    }

    /**
     *

     * @param productId  根据商品id 查询 所有图片
     * @return
     */
    @ApiOperation(value = "根据商品id 查询 所有图片")
    @PreAuthorize("@ss.hasPermi('product:product:query')")
    @GetMapping(value = "/images/{productId}")
    public AjaxResult getImgInfoByProductId(@PathVariable("productId") Long productId) {
        List<ProductImage> productImages = iProductImageService.selectProductImgByPid(productId);
        return AjaxResult.success(productImages);
    }


    /**
     * 获取商品信息详细信息
     */
    @ApiOperation(value = "获取商品信息详细信息")
    @PreAuthorize("@ss.hasPermi('product:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") @ApiParam(value = "分类id") Long productId) {
        return AjaxResult.success(productInfoService.selectProductInfoByProductId(productId));
    }

    /**
     * 新增商品信息
     */
    @ApiOperation(value = "新增商品信息")
    @PreAuthorize("@ss.hasPermi('product:product:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductInfo productInfo) {
        return toAjax(productInfoService.insertProductInfo(productInfo));
    }

    /**
     * 修改商品信息
     */
    @ApiOperation(value = "批量添加 添加商品图片")
    @ApiOperationSupport(includeParameters = {"ud","createBy","createTime","updateTime","searchValue",})
    @PreAuthorize("@ss.hasPermi('product:product:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping("/images")
    public AjaxResult addImgs(@RequestBody ListImagesOv listImagesOv) {
        //删除该商品的所有图片然后添加
        return toAjax( iProductImageService.updateProductImages(listImagesOv));
    }

    /**
     * 修改商品信息
     */
    @ApiOperation(value = "修改商品信息")
    @PreAuthorize("@ss.hasPermi('product:product:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductInfo productInfo) {
        return toAjax(productInfoService.updateProductInfo(productInfo));
    }

    /**
     * 删除商品信息
     */
    @ApiOperation(value = "删除商品信息")
    @PreAuthorize("@ss.hasPermi('product:product:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @ApiImplicitParam(name ="productIds",dataTypeClass=List.class,value = "商品id")
    @DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable(value = "productIds")  Long[] productIds) {
        return toAjax(productInfoService.deleteProductInfoByProductIds(productIds));
    }
}
