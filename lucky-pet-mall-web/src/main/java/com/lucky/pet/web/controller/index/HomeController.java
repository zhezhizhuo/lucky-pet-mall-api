package com.lucky.pet.web.controller.index;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.lucky.pet.category.service.IProductCategoryService;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.core.domain.vo.PcBanner;
import com.lucky.pet.common.core.redis.RedisCache;
import com.lucky.pet.common.utils.StringUtils;
import com.lucky.pet.home.service.IHomeBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhiZhou
 * @createDate: 2022/6/19 18:50
 */
@RestController
@RequestMapping("/public/home")
@Api(tags = "首页模块 包括uniApp,PC端 ")
@ApiSort(1)
public class HomeController extends BaseController {


    @Resource
    private IHomeBannerService bannerService;


    @Resource
    private IProductCategoryService categoryService;

    @Autowired
    private RedisCache redisCache;

            private  final  String BANNER_KEY ="home:banner:key" ;
    /**
     *  首页轮播图
     * @return
     */
    @ApiOperation(value = "首页轮播图")
    @GetMapping("/carousel")
    public AjaxResult getBanner(){
        //先查Redis
        List<PcBanner> cache = redisCache.getCacheObject(BANNER_KEY);
        logger.error("cache ==",cache);
        if (cache ==null || cache.size() == 0 ){
            //redis 空了 查询数据库
            List<PcBanner> pcBanner = bannerService.getPcBanner();
            redisCache.setCacheObject(BANNER_KEY,pcBanner,30, TimeUnit.HOURS);
            return AjaxResult.success(pcBanner);
        }
        return AjaxResult.success(cache);

    }

    /**
     * 获取九宫格图标
     */
    @ApiOperation(value = "uniapp 获取九宫格图标")
    @GetMapping("/nineHouseGrid")
    public AjaxResult getNineHouseGrid(){
        return AjaxResult.success(categoryService.selectCategoryNineHouseGridList());
    }
    /**
     * 获取分类数据
     */
    @ApiOperation(value = " uniapp获取分类数据" ,tags = "uniapp 部分")
    @GetMapping("/category")
    public AjaxResult getCategory(){

        return AjaxResult.success(categoryService.selectHomeProductCategoryList());
    }
    /**
     * 获取分类数据
     */
    @ApiOperation(value = "获取分类数据")
    @GetMapping("/top/category")
    public AjaxResult getCategoryTop(){
        return AjaxResult.success(categoryService.selectHomeProductCategoryListTop());
    }

}
