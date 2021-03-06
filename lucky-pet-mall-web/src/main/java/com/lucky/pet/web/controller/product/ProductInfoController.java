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
 * ????????????Controller
 *
 * @author qgj
 * @date 2022-06-20
 */
@RestController

@Api( tags = "???????????? ??????")
@RequestMapping("/product/product")
public class ProductInfoController extends BaseController {
    @Resource
    private IProductInfoService productInfoService;

    @Resource
    private IProductImageService iProductImageService;

    /**
     * ????????????????????????
     */
    @ApiOperation(value = "????????????????????????")
    @PreAuthorize("@ss.hasPermi('product:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductInfo productInfo) {
        startPage();

        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        return getDataTable(list);
    }

    /**
     * ????????????????????????
     */
    @ApiOperation(value = "????????????????????????")
    @PreAuthorize("@ss.hasPermi('product:product:export')")
    @Log(title = "????????????", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductInfo productInfo) {
        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        ExcelUtil<ProductInfo> util = new ExcelUtil<ProductInfo>(ProductInfo. class);
        util.exportExcel(response, list, "??????????????????");
    }

    /**
     *

     * @param productId  ????????????id ?????? ????????????
     * @return
     */
    @ApiOperation(value = "????????????id ?????? ????????????")
    @PreAuthorize("@ss.hasPermi('product:product:query')")
    @GetMapping(value = "/images/{productId}")
    public AjaxResult getImgInfoByProductId(@PathVariable("productId") Long productId) {
        List<ProductImage> productImages = iProductImageService.selectProductImgByPid(productId);
        return AjaxResult.success(productImages);
    }


    /**
     * ??????????????????????????????
     */
    @ApiOperation(value = "??????????????????????????????")
    @PreAuthorize("@ss.hasPermi('product:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") @ApiParam(value = "??????id") Long productId) {
        return AjaxResult.success(productInfoService.selectProductInfoByProductId(productId));
    }

    /**
     * ??????????????????
     */
    @ApiOperation(value = "??????????????????")
    @PreAuthorize("@ss.hasPermi('product:product:add')")
    @Log(title = "????????????", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductInfo productInfo) {
        return toAjax(productInfoService.insertProductInfo(productInfo));
    }

    /**
     * ??????????????????
     */
    @ApiOperation(value = "???????????? ??????????????????")
    @ApiOperationSupport(includeParameters = {"ud","createBy","createTime","updateTime","searchValue",})
    @PreAuthorize("@ss.hasPermi('product:product:add')")
    @Log(title = "????????????", businessType = BusinessType.INSERT)
    @PostMapping("/images")
    public AjaxResult addImgs(@RequestBody ListImagesOv listImagesOv) {
        //??????????????????????????????????????????
        return toAjax( iProductImageService.updateProductImages(listImagesOv));
    }

    /**
     * ??????????????????
     */
    @ApiOperation(value = "??????????????????")
    @PreAuthorize("@ss.hasPermi('product:product:edit')")
    @Log(title = "????????????", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductInfo productInfo) {
        return toAjax(productInfoService.updateProductInfo(productInfo));
    }

    /**
     * ??????????????????
     */
    @ApiOperation(value = "??????????????????")
    @PreAuthorize("@ss.hasPermi('product:product:remove')")
    @Log(title = "????????????", businessType = BusinessType.DELETE)
    @ApiImplicitParam(name ="productIds",dataTypeClass=List.class,value = "??????id")
    @DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable(value = "productIds")  Long[] productIds) {
        return toAjax(productInfoService.deleteProductInfoByProductIds(productIds));
    }
}
