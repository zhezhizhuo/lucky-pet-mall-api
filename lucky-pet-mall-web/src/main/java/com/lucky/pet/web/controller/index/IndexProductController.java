package com.lucky.pet.web.controller.index;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.core.page.TableDataInfo;
import com.lucky.pet.product.service.IProductCommentService;
import com.lucky.pet.product.service.IProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhiZhou
 * @createDate: 2022/7/3 18:32
 */
@RestController
@RequestMapping("/public/home")
@Api(tags = "商品模块 包括uniApp,PC端 ")
@ApiSort(2)
public class IndexProductController extends BaseController {


    @Resource
    private IProductInfoService productInfoService;


    /**
     *  uniapp
     *   无限加载商品
     * @return
     */
    @ApiOperation(value = "uniapp 推荐商品")
    @GetMapping("/app/product")
    public TableDataInfo getBanner(){
        startPage();
        return getDataTable(productInfoService.selectProductListByUniappIndex());
    }


    @ApiOperation(value = "商品详情")
    @GetMapping("/productInfo")
    public AjaxResult getProductInfo(Long id){
        Long userId = -1L;
        try{
             userId = getUserId();
        }catch (Exception e){
        }
        return AjaxResult.success(productInfoService.selectProductInfoById(id,userId));
    }

    /**
     * 商品评论信息
     * @param id
     * @return
     */
    @GetMapping("/goods")
    @ApiOperation(value = "商品评论信息", notes = "传入商品Id 查询商品的所有评论")
    public TableDataInfo goodComments(@RequestParam @ApiParam("商品id") Long id,@RequestParam(defaultValue = "1") @ApiParam("排序方式 1 按时间查询 , 2 按照喜欢人数查询") String type) {
        startPage();
        if ("1".equals(type)){
            return getDataTable(productInfoService.selectProductCommentByPid(id));
        }else {
            return getDataTable(productInfoService.selectProductCommentByPidHot(id));
        }
    }
}
