package com.lucky.pet.web.controller.index;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.core.domain.vo.CategoryTreeOv;
import com.lucky.pet.common.core.page.TableDataInfo;
import com.lucky.pet.product.service.IProductCommentService;
import com.lucky.pet.product.service.IProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
     *     首页
     *     主体数据模型
     * @return
     */
    @GetMapping("/categoryInfo")
    @ApiOperation(value = "首页头部商品数据")
    public AjaxResult getCategoryGoods() {
        //先查询 redis
//        List<CategoryBean> cache = redisCache.getCacheObject(CACHE_KEY_GOODS);
        //有就直接放回
//        if(StringUtils.isNotEmpty(cache)){
//            return  AjaxResult.success(cache);
//        }
        //没有就查询数据库
        List<CategoryTreeOv> categorys = productInfoService.buildCategoryGoods( );
        //把数据存入 redis
//        redisCache.setCacheObject(CACHE_KEY_GOODS,categorys,30, TimeUnit.MINUTES);
        return AjaxResult.success(categorys);
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
